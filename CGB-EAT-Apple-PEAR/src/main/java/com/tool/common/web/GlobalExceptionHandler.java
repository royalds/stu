package com.tool.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**全局异常处理类*/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	private Logger log=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	//JDK中的自带的日志API
		@ExceptionHandler(RuntimeException.class)
	    @ResponseBody
		public JsonResult doHandleRuntimeException(RuntimeException e){
			log.error(e.getMessage());
	    	e.printStackTrace();//也可以写日志
			return new JsonResult(e);//封装异常信息
		}
}
