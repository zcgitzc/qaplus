package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaUserClass;
import com.qaplus.mapper.QaUserClassMapperExt;
import com.qaplus.service.UserClassService;

@Service
public class UserClassServiceImpl implements UserClassService {
	@Resource
	private QaUserClassMapperExt userClassMapperExt;

	@Override
	public void add(QaUserClass userClass) {
		userClassMapperExt.insertSelective(userClass);
	}

}
