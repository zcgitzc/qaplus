package com.qaplus.mapper;

import com.qaplus.entity.QaExamQuestion;
import com.qaplus.entity.QaExamQuestionExample;
import java.util.List;

public interface QaExamQuestionMapper {
    int countByExample(QaExamQuestionExample example);

    int deleteByExample(QaExamQuestionExample example);

    int deleteByPrimaryKey(QaExamQuestion record);

    int insertSelective(QaExamQuestion record);

    List<QaExamQuestion> selectByExample(QaExamQuestionExample example);

    QaExamQuestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaExamQuestion record);
}