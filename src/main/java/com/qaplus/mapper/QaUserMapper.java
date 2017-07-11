package com.qaplus.mapper;

import com.qaplus.entity.QaUser;
import com.qaplus.entity.QaUserExample;
import java.util.List;

public interface QaUserMapper {
    int countByExample(QaUserExample example);

    int deleteByExample(QaUserExample example);

    int deleteByPrimaryKey(QaUser record);

    int insertSelective(QaUser record);

    List<QaUser> selectByExample(QaUserExample example);

    QaUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaUser record);
}