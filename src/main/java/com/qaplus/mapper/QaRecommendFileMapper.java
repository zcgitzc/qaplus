package com.qaplus.mapper;

import com.qaplus.entity.QaRecommendFile;
import com.qaplus.entity.QaRecommendFileExample;
import java.util.List;

public interface QaRecommendFileMapper {
    int countByExample(QaRecommendFileExample example);

    int deleteByExample(QaRecommendFileExample example);

    int deleteByPrimaryKey(QaRecommendFile record);

    int insertSelective(QaRecommendFile record);

    List<QaRecommendFile> selectByExample(QaRecommendFileExample example);

    QaRecommendFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaRecommendFile record);
}