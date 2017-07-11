package com.qaplus.mapper;

import com.qaplus.entity.QaStuHwQuestion;
import com.qaplus.entity.QaStuHwQuestionExample;
import java.util.List;

public interface QaStuHwQuestionMapper {
    int countByExample(QaStuHwQuestionExample example);

    int deleteByExample(QaStuHwQuestionExample example);

    int deleteByPrimaryKey(QaStuHwQuestion record);

    int insertSelective(QaStuHwQuestion record);

    List<QaStuHwQuestion> selectByExample(QaStuHwQuestionExample example);

    QaStuHwQuestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuHwQuestion record);
}