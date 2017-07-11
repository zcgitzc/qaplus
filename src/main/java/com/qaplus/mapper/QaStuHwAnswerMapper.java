package com.qaplus.mapper;

import com.qaplus.entity.QaStuHwAnswer;
import com.qaplus.entity.QaStuHwAnswerExample;
import java.util.List;

public interface QaStuHwAnswerMapper {
    int countByExample(QaStuHwAnswerExample example);

    int deleteByExample(QaStuHwAnswerExample example);

    int deleteByPrimaryKey(QaStuHwAnswer record);

    int insertSelective(QaStuHwAnswer record);

    List<QaStuHwAnswer> selectByExample(QaStuHwAnswerExample example);

    QaStuHwAnswer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuHwAnswer record);
}