package com.rw.finance.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UuidUtil {
	/**
	 * uuid 生成器
	 * @return
	 */
	public static String uuidBuilder(){
		return UUID.randomUUID().toString();
	}
	/***
	 * 流水号生成器
	 * @param prefix 前缀
	 * @return
	 */
	public static String tradeNoBuilder(String prefix){
		int hashCode=UUID.randomUUID().toString().hashCode();
		if(hashCode<0){
			hashCode=-hashCode;
		}
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+hashCode;
	}
}
