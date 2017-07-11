package com.qaplus.mapper;

import com.qaplus.entity.QaResources;
import com.qaplus.entity.QaResourcesExample;
import java.util.List;

public interface QaResourcesMapper {
    int countByExample(QaResourcesExample example);

    int deleteByExample(QaResourcesExample example);

    int deleteByPrimaryKey(QaResources record);

    int insertSelective(QaResources record);

    List<QaResources> selectByExample(QaResourcesExample example);

    QaResources selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaResources record);
}