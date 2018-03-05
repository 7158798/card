package com.rw.finance.task.config;
import org.springframework.util.StringUtils;

import com.rw.finance.task.utils.BeanService;
import com.rw.finance.task.utils.SpringUtil;

/**
 * 
 * @file SystemSettingConstants.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午8:34:52
 * @declaration
 */
public class SystemSettingConstants {
	/**
	 * 
	 * @file SystemSettingConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午8:41:44
	 * @declaration
	 */
	public enum SystemSetting{
		PAY_SYSTEM_RATE("PAY_SYSTEM_RATE");
		private String key;
		SystemSetting(String key){
			this.key=key;
		}
		public String getValue(){
			Object value=SpringUtil.getBean(BeanService.class).baseCacheService.get(key,String.class);
			if(!StringUtils.isEmpty(value)){
				return value.toString();
			}
			return SpringUtil.getBean(BeanService.class).systemSettingService.getByDictkey(key).getDictval();
		}
	}

}
