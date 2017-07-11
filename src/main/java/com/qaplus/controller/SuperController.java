package com.qaplus.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SuperController {
	
	/**
	 * 所有的Controller发生RuntimeException时，到WrapDataResponseBodyAdvice.java 中进行处理 
	 * @param runtimeException
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
    public Exception runtimeExceptionHandler(RuntimeException runtimeException) {  
        return runtimeException;
    }
	
	
}
