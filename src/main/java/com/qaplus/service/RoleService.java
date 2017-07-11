package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaRole;

public interface RoleService {
	// 查看用户有哪些角色
	List<QaRole> queryUserRole(Long userId);
}
