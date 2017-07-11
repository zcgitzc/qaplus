package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaTask;
@Repository
public interface QaTaskMapperExt extends QaTaskMapper{
    List<QaTask> queryTaskByUserId(@Param("userId")Long userId);
}