package com.qaplus.mapper;

import com.qaplus.entity.QaStuAnswer;
import com.qaplus.entity.QaStuAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QaStuAnswerMapper {
    int countByExample(QaStuAnswerExample example);

    int deleteByExample(QaStuAnswerExample example);

    int deleteByPrimaryKey(QaStuAnswer record);

    int insertSelective(QaStuAnswer record);

    List<QaStuAnswer> selectByExample(QaStuAnswerExample example);

    QaStuAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QaStuAnswer record, @Param("example") QaStuAnswerExample example);

    int updateByExample(@Param("record") QaStuAnswer record, @Param("example") QaStuAnswerExample example);

    int updateByPrimaryKeySelective(QaStuAnswer record);
}