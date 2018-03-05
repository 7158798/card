package com.rw.finance.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huanghongfei
 * @file AgentInfoAuthor.java
 * @date 2017年12月9日 下午6:34:14
 * @declaration
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgentInfoAuthor {
    int level();
}
