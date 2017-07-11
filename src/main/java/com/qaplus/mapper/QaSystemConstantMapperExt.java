package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaSystemConstant;
import com.qaplus.entity.vo.Page;

@Repository
public interface QaSystemConstantMapperExt extends QaSystemConstantMapper {

	List<QaSystemConstant> queryForPage(@Param("page") Page page, @Param("searchKey") String searchKey);

	int countForPage(@Param("searchKey") String searchKey);
}