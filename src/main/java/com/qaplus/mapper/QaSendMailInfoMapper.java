package com.qaplus.mapper;

import com.qaplus.entity.QaSendMailInfo;
import com.qaplus.entity.QaSendMailInfoExample;
import java.util.List;

public interface QaSendMailInfoMapper {
    int countByExample(QaSendMailInfoExample example);

    int deleteByExample(QaSendMailInfoExample example);

    int deleteByPrimaryKey(QaSendMailInfo record);

    int insertSelective(QaSendMailInfo record);

    List<QaSendMailInfo> selectByExample(QaSendMailInfoExample example);

    QaSendMailInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaSendMailInfo record);
}