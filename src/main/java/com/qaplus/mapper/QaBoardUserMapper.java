package com.qaplus.mapper;

import com.qaplus.entity.QaBoardUser;
import com.qaplus.entity.QaBoardUserExample;
import java.util.List;

public interface QaBoardUserMapper {
    int countByExample(QaBoardUserExample example);

    int deleteByExample(QaBoardUserExample example);

    int deleteByPrimaryKey(QaBoardUser record);

    int insertSelective(QaBoardUser record);

    List<QaBoardUser> selectByExample(QaBoardUserExample example);

    QaBoardUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaBoardUser record);
}