package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaResources;
@Repository
public interface QaResourcesMapperExt extends QaResourcesMapper{
	List<QaResources> selectUserResources(@Param("userId")Long userId);
	List<QaResources> selectHomeResources(@Param("userId")Long userId);
}