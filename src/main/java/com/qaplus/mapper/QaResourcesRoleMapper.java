package com.qaplus.mapper;

import com.qaplus.entity.QaResourcesRole;
import com.qaplus.entity.QaResourcesRoleExample;
import java.util.List;

public interface QaResourcesRoleMapper {
    int countByExample(QaResourcesRoleExample example);

    int deleteByExample(QaResourcesRoleExample example);

    int deleteByPrimaryKey(QaResourcesRole record);

    int insertSelective(QaResourcesRole record);

    List<QaResourcesRole> selectByExample(QaResourcesRoleExample example);

    QaResourcesRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaResourcesRole record);
}