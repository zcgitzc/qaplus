package com.qaplus.mapper;

import com.qaplus.entity.QaScore;
import com.qaplus.entity.QaScoreExample;
import java.util.List;

public interface QaScoreMapper {
    int countByExample(QaScoreExample example);

    int deleteByExample(QaScoreExample example);

    int deleteByPrimaryKey(QaScore record);

    int insertSelective(QaScore record);

    List<QaScore> selectByExample(QaScoreExample example);

    QaScore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaScore record);
}