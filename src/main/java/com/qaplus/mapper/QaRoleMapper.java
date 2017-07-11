package com.qaplus.mapper;

import com.qaplus.entity.QaRole;
import com.qaplus.entity.QaRoleExample;
import java.util.List;

public interface QaRoleMapper {
    int countByExample(QaRoleExample example);

    int deleteByExample(QaRoleExample example);

    int deleteByPrimaryKey(QaRole record);

    int insertSelective(QaRole record);

    List<QaRole> selectByExample(QaRoleExample example);

    QaRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaRole record);
}