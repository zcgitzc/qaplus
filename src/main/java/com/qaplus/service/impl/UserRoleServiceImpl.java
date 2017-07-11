package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaUserRole;
import com.qaplus.mapper.QaUserRoleMapperExt;
import com.qaplus.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private QaUserRoleMapperExt userRoleMapperExt;

	@Override
	public int addUserRole(QaUserRole userRole) {
		return userRoleMapperExt.insertSelective(userRole);
	}

}
