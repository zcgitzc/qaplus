package com.qaplus.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class MyMehtodInterceptor implements HttpMessageConverter<Object>{
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	@Override
	public boolean canRead(Class clazz, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canWrite(Class clazz, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		List<MediaType> supportedMediaTypes=new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType("application", "json", DEFAULT_CHARSET));
		supportedMediaTypes.add(new MediaType("application", "*+json", DEFAULT_CHARSET));
		return supportedMediaTypes;
	}

	@Override
	public Object read(Class clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Object t, MediaType contentType,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}
 
 
}
