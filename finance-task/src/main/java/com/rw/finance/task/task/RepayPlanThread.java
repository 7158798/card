package com.rw.finance.task.task;

import java.util.List;

import com.rw.finance.common.constants.MemberInfoConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.entity.RepayPlan;
import com.rw.finance.common.entity.RepayTask;
import com.rw.finance.common.entity.order.RepayTaskOrder;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.utils.SmsUtils;
import com.rw.finance.common.utils.UuidUtil;
import com.rw.finance.task.utils.BeanService;
import com.rw.finance.task.utils.SpringUtil;
/**
 * 
 * @file RepayPlanThread.java	
 * @author huanghongfei
 * @date 2017年12月19日 下午8:46:40
 * @declaration
 */
public class RepayPlanThread extends Thread{

	private static final Logger log=LoggerFactory.getLogger(RepayPlanTask.class);
	
	private long taskid;

	public RepayPlanThread(long taskid){
		this.taskid=taskid;
	}
	
	@Override
	public void run() {
		//获取互斥锁，分布式定时任务
		if(SpringUtil.getBean(BeanService.class).baseCacheService.incr("REPAY_TASK_SYNC_"+this.taskid)!=1){
			return;
		}
		RepayTask repayTask=SpringUtil.getBean(BeanService.class).repayTaskService.getByTaskid(taskid);
		MemberInfo memberInfo=SpringUtil.getBean(BeanService.class).memberInfoService.getByMemberid(repayTask.getMemberid());
		RepayPlan repayPlan=SpringUtil.getBean(BeanService.class).repayPlanService.getByPlanid(repayTask.getPlanid());
		MemberCard memberCard=SpringUtil.getBean(BeanService.class).memberCardService.getByMemberidAndCardid(repayPlan.getMemberid(), repayPlan.getCardid());
		if(memberInfo.getLevel().intValue()<= MemberInfoConstants.Level.LEVEL_0){
			log.info("member level expire,memberId:{}",memberInfo.getMemberid());
			return;
		}
		//扣款-从信用卡
		if(repayTask.getTasktype().intValue()==RepayTaskConstants.Type.TYPE0.getType()){
			log.info("pay begining...");
			String tradeNo=UuidUtil.tradeNoBuilder(OrderInfoConstants.Prefix.RepayTaskOrder.getPrefix());
			PayResult payResult=this.pay(tradeNo,memberInfo,memberCard,repayTask);//需要等待支付回调
			if(!payResult.getSuccess()){
				repayTask.setStatus(RepayTaskConstants.Status.STATUS2.getStatus());
				SpringUtil.getBean(BeanService.class).repayTaskService.update(repayTask);
				SmsUtils.sendError(memberInfo.getTelephone(),"还款任务");
			}
			OrderInfo orderInfo=new OrderInfo(repayTask.getMemberid(),memberInfo.getRealname(),tradeNo,repayTask.getTaskamount(),repayTask.getActualamount(),SpringUtil.getBean(BeanService.class).payChannelService.getByIsdef().getChannelid(),payResult.getPayTradeNo(), OrderInfoConstants.Type.RepayTaskOrder.getType(), "",
					new Gson().toJson(new RepayTaskOrder(repayPlan.getPlanid(),repayTask.getTaskid())));
			if(!payResult.getSuccess()){
				orderInfo.setStatus(OrderInfoConstants.Status.STATUS2.getStatus());
			}
			orderInfo.setRemark(payResult.getDetails());
			SpringUtil.getBean(BeanService.class).orderInfoService.add(orderInfo);
			log.info("current operation pay, repayTask created orderInfo,the orderInfo status:{}",payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS0.getStatus());
		}
		//还款-到信用卡
		if(repayTask.getTasktype().intValue()==RepayTaskConstants.Type.TYPE1.getType()){
			log.info("repay begining...");
			String tradeNo=UuidUtil.tradeNoBuilder(OrderInfoConstants.Prefix.RepayTaskOrder.getPrefix());
			PayResult payResult=this.repay(tradeNo,memberInfo,memberCard,repayTask);//创新代付是马上拿到结果，立即修改状态
			if(!payResult.getSuccess()){
				SmsUtils.sendError(memberInfo.getTelephone(),"还款任务");
			}
			repayTask.setStatus(payResult.getSuccess()?RepayTaskConstants.Status.STATUS1.getStatus():RepayTaskConstants.Status.STATUS2.getStatus());
			SpringUtil.getBean(BeanService.class).repayTaskService.update(repayTask);
			OrderInfo orderInfo=new OrderInfo(repayTask.getMemberid(),memberInfo.getRealname(),tradeNo,repayTask.getTaskamount(),repayTask.getActualamount(),SpringUtil.getBean(BeanService.class).payChannelService.getByIsdef().getChannelid(),payResult.getPayTradeNo(), OrderInfoConstants.Type.RepayTaskOrder.getType(), "",
				new Gson().toJson(new RepayTaskOrder(repayPlan.getPlanid(),repayTask.getTaskid())));
			orderInfo.setStatus(payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS2.getStatus());
			orderInfo.setRemark(payResult.getDetails());
			SpringUtil.getBean(BeanService.class).orderInfoService.add(orderInfo);
			log.info("current operation repay, repayTask created orderInfo,the orderInfo status:{}",payResult.getSuccess()?OrderInfoConstants.Status.STATUS1.getStatus():OrderInfoConstants.Status.STATUS0.getStatus());
			//验证所有任务是否已执行完
			List<RepayTask> repayTasks=SpringUtil.getBean(BeanService.class).repayTaskService.listByMemberidAndPlanidAndBatch(repayTask.getMemberid(), repayTask.getPlanid(), repayTask.getBatch()+1);
			if(repayTasks.isEmpty()){//已经是还款任务，下一批数据已空
				repayPlan.setStatus(RepayPlanConstants.Status.STATUS9.getStatus());
				SpringUtil.getBean(BeanService.class).repayPlanService.update(repayPlan);
			}
		}
	}
	
	/**
	 * 还款 
	 */
	private PayResult repay(String tradeNo,MemberInfo memberInfo, MemberCard memberCard,RepayTask repayTask){
		PayerBo.OrderInfo oi=new PayerBo().new OrderInfo(tradeNo, "", repayTask.getTaskamount(),new PayerFactory().DefaultPayer().getBackUrl(),"");
		oi.setRemark("");//必须设置，不然会有个null被叠加上去
		List<RepayTask> repayTasks=SpringUtil.getBean(BeanService.class).repayTaskService.listByMemberidAndPlanidAndBatch(repayTask.getMemberid(), repayTask.getPlanid(),repayTask.getBatch());
		Object[] rts=repayTasks.stream().filter(i  -> {return i.getTasktype() !=RepayTaskConstants.Type.TYPE1.getType();}).toArray();
		for(int i=0;i<rts.length;i++){//获取订单流水号集合
			OrderInfo orderInfo=SpringUtil.getBean(BeanService.class).orderInfoService.getByDetailsLike("\"taskId\":"+repayTasks.get(i).getTaskid());
			if(StringUtils.isEmpty(orderInfo)){
				break;//如果这个订单是空的，说明当前批次的扣款任务有失败，不能还款，使用支付通道返回的错误结束任务,
			}
			if(orderInfo.getStatus().intValue()!=OrderInfoConstants.Status.STATUS1.getStatus()){
				//如果当前扣款任务批次中有失败的订单，不能进行还款
				return new PayResult("500", false, "", tradeNo,"", 0);
			}
			oi.setRemark(oi.getRemark()+orderInfo.getTradeno());
			if(i==rts.length-1){//最后一个了
				break;
			}
			oi.setRemark(oi.getRemark()+",");
		}
		return new PayerFactory().DefaultPayer().repay(new PayerBo().new UserInfo(memberInfo.getIdnumber(), memberInfo.getRealname()),
				new PayerBo().new CardInfo(memberCard.getBankname(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(), memberCard.getCardno(), memberCard.getMobile(), memberCard.getAuthcode(),memberCard.getExpirydate()),
				oi);
	}
	/**
	 * 扣款
	 */
	private PayResult pay(String tradeNo,MemberInfo memberInfo,MemberCard memberCard,RepayTask repayTask){
		return new PayerFactory().DefaultPayer().pay(new PayerBo().new UserInfo(memberInfo.getIdnumber(), memberInfo.getRealname()),
				new PayerBo().new CardInfo(memberCard.getBankname(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(), memberCard.getCardno(), memberCard.getMobile(), memberCard.getAuthcode(),memberCard.getExpirydate()),
				new PayerBo().new OrderInfo(tradeNo, "", repayTask.getActualamount(),new PayerFactory().DefaultPayer().getBackUrl(),""));
	}
}
