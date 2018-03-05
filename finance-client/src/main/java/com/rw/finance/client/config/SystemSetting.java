package com.rw.finance.client.config;

import com.google.gson.Gson;
import com.rw.finance.client.vo.SystemVo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rw.finance.common.service.BaseCacheService;
import com.rw.finance.common.service.SystemSettingService;
/**
 * 
 * @file SystemSettingService.java	
 * @author huanghongfei
 * @date 2018年1月16日 下午2:40:55
 * @declaration
 */
@Component
public class SystemSetting {

	@Reference
	private SystemSettingService systemSettingService;
	
	@Reference
	private BaseCacheService baseCacheService;
	/**
	 * 二维码上面的报文地址
	 * @return
	 */
	public String QR_CODE_SHARE_URL_REQUEST(){
		String key="QR_CODE_SHARE_URL_REQUEST";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return value.toString();
		}
		return systemSettingService.getByDictkey(key).getDictval();
	}
	/**
	 * 二维码分享地址落地页
	 * @return
	 */
	public String QR_CODE_SHARE_URL_REDIRECT(){
		String key="QR_CODE_SHARE_URL_REDIRECT";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return value.toString();
		}
		return systemSettingService.getByDictkey(key).getDictval();
	}

	/**
	 * 二维码分享地址落地页
	 * @return
	 */
	public SystemVo.Version APP_LAST_VERSION(){
		return new Gson().fromJson(systemSettingService.getByDictkey("APP_LAST_VERSION").getDictval(),SystemVo.Version.class);
	}
	
}
