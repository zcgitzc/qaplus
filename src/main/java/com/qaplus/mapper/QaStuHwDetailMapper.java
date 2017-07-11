package com.qaplus.mapper;

import com.qaplus.entity.QaStuHwDetail;
import com.qaplus.entity.QaStuHwDetailExample;
import java.util.List;

public interface QaStuHwDetailMapper {
    int countByExample(QaStuHwDetailExample example);

    int deleteByExample(QaStuHwDetailExample example);

    int deleteByPrimaryKey(QaStuHwDetail record);

    int insertSelective(QaStuHwDetail record);

    List<QaStuHwDetail> selectByExample(QaStuHwDetailExample example);

    QaStuHwDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuHwDetail record);
}