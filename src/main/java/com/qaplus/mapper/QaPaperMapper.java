package com.qaplus.mapper;

import com.qaplus.entity.QaPaper;
import com.qaplus.entity.QaPaperExample;
import java.util.List;

public interface QaPaperMapper {
    int countByExample(QaPaperExample example);

    int deleteByExample(QaPaperExample example);

    int deleteByPrimaryKey(QaPaper record);

    int insertSelective(QaPaper record);

    List<QaPaper> selectByExample(QaPaperExample example);

    QaPaper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaPaper record);
}