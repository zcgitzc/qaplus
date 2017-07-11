package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaBoardUser;
import com.qaplus.mapper.QaBoardUserMapperExt;
import com.qaplus.service.BoardUserService;

@Service
public class BoardUserServiceImpl implements BoardUserService {
	
	@Resource
	private QaBoardUserMapperExt boardUserMapperExt;
		
	@Override
	public int addUserBoard(QaBoardUser boardUser) {
		return boardUserMapperExt.insertSelective(boardUser);
	}

}
