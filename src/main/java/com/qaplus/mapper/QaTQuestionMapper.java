package com.qaplus.mapper;

import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.QaTQuestionExample;
import java.util.List;

public interface QaTQuestionMapper {
    int countByExample(QaTQuestionExample example);

    int deleteByExample(QaTQuestionExample example);

    int deleteByPrimaryKey(QaTQuestion record);

    int insertSelective(QaTQuestion record);

    List<QaTQuestion> selectByExample(QaTQuestionExample example);

    QaTQuestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaTQuestion record);
}