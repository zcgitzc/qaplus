package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaRole;

@Repository
public interface QaRoleMapperExt extends QaRoleMapper{
	List<QaRole> queryUserRole(@Param("userId") Long userId);
}