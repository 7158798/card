package com.rw.finance.common.utils;

import java.util.Random;

/**
 * 数字工具类
 * @file NumberUtils.java	
 * @author huanghongfei
 * @date 2017年12月18日 下午4:18:00
 * @declaration
 */
public class NumberUtils {

	/**
	 * 生成制定范围内的随机数
	 * @param min 最小数
	 * @param max 最大数
	 * @return
	 */
	public static int fieldRandom(int min,int max){
		return new Random().nextInt(max)%(max-min+1) + min;
	}
	/**
	 * 获取范围内的double随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static double doubleRadom(double min,double max){
		return  min + new Random().nextDouble() * (max - min);
	}
}
