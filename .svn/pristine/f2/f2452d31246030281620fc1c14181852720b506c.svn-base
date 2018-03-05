package com.rw.finance.client.controller;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.annotation.MemberInfoAuthor;
import com.rw.finance.client.vo.MemberProfitVo;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.MemberProfit;
import com.rw.finance.common.service.MemberProfitService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file MemberProfitController.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:48:06
 * @declaration
 */
@RestController
@RequestMapping(value="/member/profit")
public class MemberProfitController {

	@Reference
	private MemberProfitService memberProfitService;
	/**
	 * 根据用户编号和分润等级获取分润列表
	 * @param memberid 会员编号
	 * @param level 分润等级
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndLevel")
	public Result<Object> listByMemberidAndLevel(@RequestAttribute(value="memberid",required=true)long memberid,
			@RequestParam(value="level",required=true)int level,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<MemberProfit> memberProfits=memberProfitService.listByMemberidAndLevel(memberid, level,page,size);
		return new Result<Object>(200,null,memberProfits);
	}
	/**
	 * 获取会员收益列表
	 * @param memberid
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberid")
	public Result<Object> listByMemberid(@RequestAttribute(value="memberid",required=true)long memberid,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<MemberProfit> memberProfits=memberProfitService.listByMemberid(memberid,page,size);
		return new Result<Object>(200,null,memberProfits);
	}
	/**
	 * 分组统计收益
	 * @param memberid
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/countByMemberidGroupLevel")
	public Result<Object> countByMemberidGroupLevel(@RequestAttribute(value="memberid",required=true)long memberid){
		List<Object[]> lists=memberProfitService.countByMemberidGroupLevel(memberid);
		MemberProfitVo.MemberProfitCountVo vo=new MemberProfitVo().new MemberProfitCountVo();
		Calendar calendar=Calendar.getInstance();
		double toDayProfit=memberProfitService.sumProfitByMemberidAndDate(memberid,DateUtils.getDateStr(calendar.getTime()));
		vo.setToDayProfit(toDayProfit);//今日收益
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-1);
		double yesterDayProfit=memberProfitService.sumProfitByMemberidAndDate(memberid,DateUtils.getDateStr(calendar.getTime()));
		vo.setYesterDayProfit(yesterDayProfit);//昨日收益
		lists.forEach(list->{
			double levelProfit=(double)list[0];
			double levelTotalBizAmount=(double)list[1];
			BigInteger levelMemberCount=(BigInteger)list[2];
			MemberProfitVo.MemberProfitCountVo.ProfitLevel profitLevel=new MemberProfitVo().new MemberProfitCountVo().new ProfitLevel(levelProfit, levelTotalBizAmount, levelMemberCount.longValue());
			vo.getProfitLevels().add(profitLevel);
			vo.setTotalProfit(MathUtils.add(StringUtils.isEmpty(vo.getTotalProfit())?0:vo.getTotalProfit(),levelProfit));
		});
		return new Result<Object>(200,null,vo);
	}
	
}
