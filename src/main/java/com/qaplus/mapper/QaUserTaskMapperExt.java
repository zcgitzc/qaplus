package com.qaplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface QaUserTaskMapperExt extends QaUserTaskMapper{

	void delUserTask(@Param("taskId") Long taskId);
}