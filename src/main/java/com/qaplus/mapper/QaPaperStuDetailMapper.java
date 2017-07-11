package com.qaplus.mapper;

import com.qaplus.entity.QaPaperStuDetail;
import com.qaplus.entity.QaPaperStuDetailExample;
import java.util.List;

public interface QaPaperStuDetailMapper {
    int countByExample(QaPaperStuDetailExample example);

    int deleteByExample(QaPaperStuDetailExample example);

    int deleteByPrimaryKey(QaPaperStuDetail record);

    int insertSelective(QaPaperStuDetail record);

    List<QaPaperStuDetail> selectByExample(QaPaperStuDetailExample example);

    QaPaperStuDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaPaperStuDetail record);
}