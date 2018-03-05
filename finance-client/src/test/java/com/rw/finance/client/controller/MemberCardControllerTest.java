package com.rw.finance.client.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.client.BaseTest;
import com.rw.finance.common.service.BaseCacheService;

/**
 * 
 * @file MemberCardControllerTest.java
 * @author huanghongfei
 * @date 2017年12月13日 下午5:24:46
 * @declaration
 */
public class MemberCardControllerTest extends BaseTest{

	@Autowired
	private MemberCardController memberCardController;
	@Reference
	private BaseCacheService baseCacheService;
	/**
	 * 测试添加储蓄卡
	 */
	//@Test
	public void addTest(){
		System.err.println(memberCardController.add(1,1, "6226011026785669","15023343740").getCode());
	}
	/**
	 * 测试获取储蓄卡列表
	 */
	@Test
	public void listByMemberidAndTypeTest(){
		System.out.println(memberCardController.listByMemberidAndType(29).getData());
	}
	
	//@Test
	public void add(){
		memberCardController.add(22, 1, "6217996900028884931","15320903578");
	}

}
