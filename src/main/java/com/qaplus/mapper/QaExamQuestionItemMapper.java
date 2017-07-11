package com.qaplus.mapper;

import com.qaplus.entity.QaExamQuestionItem;
import com.qaplus.entity.QaExamQuestionItemExample;
import java.util.List;

public interface QaExamQuestionItemMapper {
    int countByExample(QaExamQuestionItemExample example);

    int deleteByExample(QaExamQuestionItemExample example);

    int deleteByPrimaryKey(QaExamQuestionItem record);

    int insertSelective(QaExamQuestionItem record);

    List<QaExamQuestionItem> selectByExample(QaExamQuestionItemExample example);

    QaExamQuestionItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaExamQuestionItem record);
}