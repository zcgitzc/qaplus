package com.qaplus.mapper;

import com.qaplus.entity.QaExamErrorQuestions;
import com.qaplus.entity.QaExamErrorQuestionsExample;
import java.util.List;

public interface QaExamErrorQuestionsMapper {
    int countByExample(QaExamErrorQuestionsExample example);

    int deleteByExample(QaExamErrorQuestionsExample example);

    int deleteByPrimaryKey(QaExamErrorQuestions record);

    int insertSelective(QaExamErrorQuestions record);

    List<QaExamErrorQuestions> selectByExample(QaExamErrorQuestionsExample example);

    QaExamErrorQuestions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaExamErrorQuestions record);
}