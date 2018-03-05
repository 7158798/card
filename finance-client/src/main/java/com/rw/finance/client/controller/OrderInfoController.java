package com.rw.finance.client.controller;

import java.util.ArrayList;
import java.util.List;

import com.rw.finance.common.constants.OrderInfoConstants;
import org.apache.tools.ant.taskdefs.condition.Or;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.annotation.MemberInfoAuthor;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.OrderInfo;
import com.rw.finance.common.service.OrderInfoService;
import com.rw.finance.common.utils.Result;

/**
 * 订单信息
 * @file OrderInfoController.java	
 * @author huanghongfei
 * @date 2017年12月23日 上午9:12:22
 * @declaration
 */
@RestController
@RequestMapping(value="/order/info")
public class OrderInfoController {

	@Reference
	private OrderInfoService orderInfoService;

	/**
	 * 根据会员编号获取还款记录
	 * @param memberid 会员编号
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndType")
	public Result<Object> listByMemberidAndType(@RequestAttribute(value="memberid",required=true)long memberid,
			@RequestParam(value="type",required=true)int type,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<OrderInfo> orderInfos=orderInfoService.listByMemberidAndType(memberid,type, page, size);
		return new Result<Object>(200,null,orderInfos.stream().filter(orderInfo -> {
			return orderInfo.getType().intValue()== OrderInfoConstants.Type.MemberBorrowOrder.getType()&&orderInfo.getStatus().intValue()==OrderInfoConstants.Status.STATUS0.getStatus()?false:true;
		}).toArray());
	}
}
