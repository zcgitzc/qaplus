package com.qaplus.mapper;

import com.qaplus.entity.QaTask;
import com.qaplus.entity.QaTaskExample;
import java.util.List;

public interface QaTaskMapper {
    int countByExample(QaTaskExample example);

    int deleteByExample(QaTaskExample example);

    int deleteByPrimaryKey(QaTask record);

    int insertSelective(QaTask record);

    List<QaTask> selectByExample(QaTaskExample example);

    QaTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaTask record);
}