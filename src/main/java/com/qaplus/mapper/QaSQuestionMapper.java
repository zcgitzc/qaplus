package com.qaplus.mapper;

import com.qaplus.entity.QaSQuestion;
import com.qaplus.entity.QaSQuestionExample;
import java.util.List;

public interface QaSQuestionMapper {
    int countByExample(QaSQuestionExample example);

    int deleteByExample(QaSQuestionExample example);

    int deleteByPrimaryKey(QaSQuestion record);

    int insertSelective(QaSQuestion record);

    List<QaSQuestion> selectByExample(QaSQuestionExample example);

    QaSQuestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaSQuestion record);
}