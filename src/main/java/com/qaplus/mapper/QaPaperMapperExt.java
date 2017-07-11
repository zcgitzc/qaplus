package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.PaperVo;

@Repository
public interface QaPaperMapperExt extends QaPaperMapper {

	List<PaperVo> queryAllPaperForPage(@Param("page") Page page, @Param("categorys") String[] categorys, @Param("title") String title, @Param("my") Long my, @Param("status") String[] status);

	int countForQueryAll(@Param("categorys") String[] categorys, @Param("title") String title, @Param("my") Long my, @Param("status") String[] status);

	List<PaperVo> queryStuPapers(@Param("stuId") Long stuId);

}