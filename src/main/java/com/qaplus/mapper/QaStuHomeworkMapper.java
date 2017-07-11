package com.qaplus.mapper;

import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.QaStuHomeworkExample;
import java.util.List;

public interface QaStuHomeworkMapper {
    int countByExample(QaStuHomeworkExample example);

    int deleteByExample(QaStuHomeworkExample example);

    int deleteByPrimaryKey(QaStuHomework record);

    int insertSelective(QaStuHomework record);

    List<QaStuHomework> selectByExample(QaStuHomeworkExample example);

    QaStuHomework selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuHomework record);
}