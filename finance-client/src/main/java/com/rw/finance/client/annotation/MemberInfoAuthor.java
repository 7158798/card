package com.rw.finance.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @file MemberInfoAuthor.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:18:59
 * @declaration
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberInfoAuthor {
	
	int level();

}
