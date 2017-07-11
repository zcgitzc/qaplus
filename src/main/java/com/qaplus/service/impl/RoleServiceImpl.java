package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qaplus.entity.QaRole;
import com.qaplus.mapper.QaRoleMapperExt;
import com.qaplus.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private QaRoleMapperExt roleMapperExt;
	
	@Cacheable(value="role")
	@Override
	public List<QaRole> queryUserRole(Long userId) {
		return roleMapperExt.queryUserRole(userId);
	}

}
