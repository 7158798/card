package com.rw.finance.client.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.common.entity.SystemSetting;
import com.rw.finance.common.service.SystemSettingService;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file SystemSettingController.java	
 * @author huanghongfei
 * @date 2018年1月4日 上午11:47:36
 * @declaration
 */
@RestController
@RequestMapping(value="/system/setting")
public class SystemSettingController {

	@Reference
	private SystemSettingService systemSettingService;
	/**
	 * 客户端加载配置表
	 * @return
	 */
	@PostMapping(value="/listByIsapp")
	public Result<Object> listByIsapp(){
		List<SystemSetting> systemSettings=systemSettingService.listByIsapp();
		return new Result<Object>(200,null,systemSettings);
	}
}
