package com.qaplus.mapper;

import com.qaplus.entity.QaAttachment;
import com.qaplus.entity.QaAttachmentExample;
import java.util.List;

public interface QaAttachmentMapper {
    int countByExample(QaAttachmentExample example);

    int deleteByExample(QaAttachmentExample example);

    int deleteByPrimaryKey(QaAttachment record);

    int insertSelective(QaAttachment record);

    List<QaAttachment> selectByExample(QaAttachmentExample example);

    QaAttachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QaAttachment record);
}