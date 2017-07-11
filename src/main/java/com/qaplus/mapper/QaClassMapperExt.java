package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaClass;
import com.qaplus.entity.vo.Page;

@Repository
public interface QaClassMapperExt extends QaClassMapper {
	List<QaClass> queryAllClassForPage(@Param("page") Page page);

	int countAllClassForPage();

	List<QaClass> queryClassByUserId(@Param("userId")Long userId);
}
