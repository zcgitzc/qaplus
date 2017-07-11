package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaRecommendFile;
import com.qaplus.entity.cond.QueryRecommendFileCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.RecommendFileVo;

@Repository
public interface QaRecommendFileMapperExt extends QaRecommendFileMapper{
	List<QaRecommendFile> queryQaRecommendFileForPage(@Param("page")Page page,@Param("cond") QueryRecommendFileCond cond);
	int countQaRecommendFileForPage(@Param("cond") QueryRecommendFileCond cond);
	RecommendFileVo queryRecommendWithAttachById(Long id);
}