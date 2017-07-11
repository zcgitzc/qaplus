package com.qaplus.mapper;

import com.qaplus.entity.QaUserRole;
import com.qaplus.entity.QaUserRoleExample;
import java.util.List;

public interface QaUserRoleMapper {
    int countByExample(QaUserRoleExample example);

    int deleteByExample(QaUserRoleExample example);

    int deleteByPrimaryKey(QaUserRole record);

    int insertSelective(QaUserRole record);

    List<QaUserRole> selectByExample(QaUserRoleExample example);

    QaUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaUserRole record);
}