package com.qaplus.mapper;

import com.qaplus.entity.QaUserClass;
import com.qaplus.entity.QaUserClassExample;
import java.util.List;

public interface QaUserClassMapper {
    int countByExample(QaUserClassExample example);

    int deleteByExample(QaUserClassExample example);

    int deleteByPrimaryKey(QaUserClass record);

    int insertSelective(QaUserClass record);

    List<QaUserClass> selectByExample(QaUserClassExample example);

    QaUserClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaUserClass record);
}