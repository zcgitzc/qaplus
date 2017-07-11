package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaSendMailInfo;
import com.qaplus.mapper.QaSendMailInfoMapperExt;
import com.qaplus.service.SendMailInfoService;

@Service
public class SendMailInfoServiceImpl implements SendMailInfoService {
	@Resource
	private QaSendMailInfoMapperExt sendMailInfoMapperExt;

	@Override
	public void add(QaSendMailInfo info) {
		sendMailInfoMapperExt.insertSelective(info);
	}

}
