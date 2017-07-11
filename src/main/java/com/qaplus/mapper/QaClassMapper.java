package com.qaplus.mapper;

import com.qaplus.entity.QaClass;
import com.qaplus.entity.QaClassExample;
import java.util.List;

public interface QaClassMapper {
    int countByExample(QaClassExample example);

    int deleteByExample(QaClassExample example);

    int deleteByPrimaryKey(QaClass record);

    int insertSelective(QaClass record);

    List<QaClass> selectByExample(QaClassExample example);

    QaClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaClass record);
}