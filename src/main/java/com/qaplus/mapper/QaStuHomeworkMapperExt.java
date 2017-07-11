package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.StuHomeworkVo;

@Repository
public interface QaStuHomeworkMapperExt extends QaStuHomeworkMapper {
	List<StuHomeworkVo> selectMyHomework(@Param("id") Long id);

	List<QaStuHomework> queryHomeworkForPage(@Param("homework") QaStuHomework homework, @Param("page") Page page);

	int countHomeworkForPage(@Param("homework") QaStuHomework record);
}