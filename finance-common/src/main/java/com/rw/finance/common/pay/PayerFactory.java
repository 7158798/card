package com.rw.finance.common.pay;
/**
 * 支付工厂类
 * @file PayerFactory.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午1:19:11
 * @declaration
 */
public class PayerFactory {

	/**
	 * 默认支付
	 * @return
	 */
	public Payer DefaultPayer(){
		return new DefaultPayer();
	}
	/**
	 * 爱农支付
	 * @return
	 */
	public Payer EynonPayer(){
		return new EynonPayer();
	}
	/**
	 * 绝顶支付
	 * @return
	 */
	public Payer JdsoftPayer(){
		return new JdsoftPayer();
	}
	/**
	 * 易通支付
	 * @return
	 */
	public Payer EtonePayer(){
		return new EtonePayer();
	}
	/**
	 * 创新支付
	 * @return
	 */
	public Payer ChuangXinPayer(){
		return new ChuangXinPayer();
	}
	/**
	 * 易宝支付
	 * @return
	 */
	public Payer YeeBaoPayPayer(){
		return new YeeBaoPayer();
	}

}
