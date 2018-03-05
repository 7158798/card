package com.rw.finance.client.controller;

import java.util.List;

import com.rw.finance.common.entity.BankInfo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.annotation.MemberInfoAuthor;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.service.BankInfoService;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file BankSupportController.java	
 * @author huanghongfei
 * @date 2017年12月13日 下午4:23:25
 * @declaration
 */
@RestController
@RequestMapping(value="/bank/info")
public class BankInfoController {

	@Reference
	private BankInfoService bankInfoService;
	/**
	 * 获取所有银行
	 * @return
	 */
	@MemberInfoAuthor(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/list")
	public Result<List> list(){
		List<BankInfo> bankInfos =bankInfoService.list();
		return new Result<List>(200,null, bankInfos);
	}
}
