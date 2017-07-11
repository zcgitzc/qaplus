package com.qaplus.mapper;

import com.qaplus.entity.QaPaperStu;
import com.qaplus.entity.QaPaperStuExample;
import java.util.List;

public interface QaPaperStuMapper {
    int countByExample(QaPaperStuExample example);

    int deleteByExample(QaPaperStuExample example);

    int deleteByPrimaryKey(QaPaperStu record);

    int insertSelective(QaPaperStu record);

    List<QaPaperStu> selectByExample(QaPaperStuExample example);

    QaPaperStu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaPaperStu record);
}