package com.qaplus.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.qaplus.constant.ErrorCode;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.exception.BusinessException;
import com.qaplus.exception.ParameterException;

@ControllerAdvice
public class WrapDataResponseBodyAdvice implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter methodParam, Class<? extends HttpMessageConverter<?>> converter) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object beforeBodyWrite(Object obj, MethodParameter param, MediaType media, Class<? extends HttpMessageConverter<?>> converter, ServerHttpRequest request, ServerHttpResponse response) {
		if (obj instanceof BusinessException) {
			return new ResponseData<Object>(ErrorCode.FAUILURE, ((BusinessException) obj).getMsg(), null, true);
		}else if(obj instanceof ParameterException){
			return new ResponseData<Object>(ErrorCode.FAUILURE, ((ParameterException) obj).getMsg(), null, true);
		} else if (obj instanceof Exception) {
			return new ResponseData<Object>(ErrorCode.FAUILURE, ((Exception) obj).getMessage(), null, true);
		} else if (obj instanceof List) {
			return new ResponseData<Object>(ErrorCode.SUCCESS, ErrorCode.SUCCESS.getDesc(), (List<Object>) obj, false);
		} else if (obj instanceof ResponseData<?>) {
			return (ResponseData<Object>) obj;
		}else {
			return new ResponseData<Object>(ErrorCode.SUCCESS, ErrorCode.SUCCESS.getDesc(), Arrays.asList(obj), false);
		}
	}

}