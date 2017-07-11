package com.qaplus.mapper;

import com.qaplus.entity.QaUserTask;
import com.qaplus.entity.QaUserTaskExample;
import java.util.List;

public interface QaUserTaskMapper {
    int countByExample(QaUserTaskExample example);

    int deleteByExample(QaUserTaskExample example);

    int deleteByPrimaryKey(QaUserTask record);

    int insertSelective(QaUserTask record);

    List<QaUserTask> selectByExample(QaUserTaskExample example);

    QaUserTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaUserTask record);
}