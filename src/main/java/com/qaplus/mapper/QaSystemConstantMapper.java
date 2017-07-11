package com.qaplus.mapper;

import com.qaplus.entity.QaSystemConstant;
import com.qaplus.entity.QaSystemConstantExample;
import java.util.List;

public interface QaSystemConstantMapper {
    int countByExample(QaSystemConstantExample example);

    int deleteByExample(QaSystemConstantExample example);

    int deleteByPrimaryKey(QaSystemConstant record);

    int insertSelective(QaSystemConstant record);

    List<QaSystemConstant> selectByExample(QaSystemConstantExample example);

    QaSystemConstant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaSystemConstant record);
}