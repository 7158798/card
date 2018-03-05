package com.rw.finance.client.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rw.finance.common.utils.Result;
/**
 * 
 * @file ExceptionController.java	
 * @author huanghongfei
 * @date 2017年12月22日 上午9:44:12
 * @declaration
 */
@RestControllerAdvice
public class ExceptionController {

	/*@ExceptionHandler(value=Exception.class)
	public Result<Object> exception(){
		return new Result<Object>(999,"系统异常",null);
	}*/
}
