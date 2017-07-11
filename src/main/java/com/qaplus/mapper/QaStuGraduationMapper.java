package com.qaplus.mapper;

import com.qaplus.entity.QaStuGraduation;
import com.qaplus.entity.QaStuGraduationExample;
import java.util.List;

public interface QaStuGraduationMapper {
    int countByExample(QaStuGraduationExample example);

    int deleteByExample(QaStuGraduationExample example);

    int deleteByPrimaryKey(QaStuGraduation record);

    int insertSelective(QaStuGraduation record);

    List<QaStuGraduation> selectByExample(QaStuGraduationExample example);

    QaStuGraduation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuGraduation record);
}