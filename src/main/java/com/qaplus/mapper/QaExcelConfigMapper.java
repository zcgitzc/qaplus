package com.qaplus.mapper;

import com.qaplus.entity.QaExcelConfig;
import com.qaplus.entity.QaExcelConfigExample;
import java.util.List;

public interface QaExcelConfigMapper {
    int countByExample(QaExcelConfigExample example);

    int deleteByExample(QaExcelConfigExample example);

    int deleteByPrimaryKey(QaExcelConfig record);

    int insertSelective(QaExcelConfig record);

    List<QaExcelConfig> selectByExample(QaExcelConfigExample example);

    QaExcelConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaExcelConfig record);
}