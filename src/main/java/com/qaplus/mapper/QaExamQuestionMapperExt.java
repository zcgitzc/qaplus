package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;

@Repository
public interface QaExamQuestionMapperExt extends QaExamQuestionMapper {

	List<ExamQuestionVo> queryAllForPage(@Param("title") String title, @Param("categorys") String[] categorys, @Param("page") Page page);

	int countAllForPage(@Param("title") String title, @Param("categorys") String[] categorys);

	List<ExamQuestionVo> queryAllErrorQuestions(@Param("stuId") Long stuId, @Param("categorys") String[] categorys);

	void removeErrorQuestion(@Param("stuId") Long stuId, @Param("questionId") Long questionId);

}