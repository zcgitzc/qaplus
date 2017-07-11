package com.qaplus.mapper;

import com.qaplus.entity.QaLog;
import com.qaplus.entity.QaLogExample;
import java.util.List;

public interface QaLogMapper {
    int countByExample(QaLogExample example);

    int deleteByExample(QaLogExample example);

    int deleteByPrimaryKey(QaLog record);

    int insertSelective(QaLog record);

    List<QaLog> selectByExample(QaLogExample example);

    QaLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaLog record);
}