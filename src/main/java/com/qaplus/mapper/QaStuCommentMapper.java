package com.qaplus.mapper;

import com.qaplus.entity.QaStuComment;
import com.qaplus.entity.QaStuCommentExample;
import java.util.List;

public interface QaStuCommentMapper {
    int countByExample(QaStuCommentExample example);

    int deleteByExample(QaStuCommentExample example);

    int deleteByPrimaryKey(QaStuComment record);

    int insertSelective(QaStuComment record);

    List<QaStuComment> selectByExample(QaStuCommentExample example);

    QaStuComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaStuComment record);
}