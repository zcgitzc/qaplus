package com.qaplus.mapper;

import com.qaplus.entity.QaBoard;
import com.qaplus.entity.QaBoardExample;
import java.util.List;

public interface QaBoardMapper {
    int countByExample(QaBoardExample example);

    int deleteByExample(QaBoardExample example);

    int deleteByPrimaryKey(QaBoard record);

    int insertSelective(QaBoard record);

    List<QaBoard> selectByExample(QaBoardExample example);

    QaBoard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaBoard record);
}