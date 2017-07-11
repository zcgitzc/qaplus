package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaLog;
import com.qaplus.entity.vo.Page;

@Repository
public interface QaLogMapperExt extends QaLogMapper {

	List<QaLog> queryAllLog(@Param("searchKey") String searchKey, @Param("page") Page page, @Param("rightLog") String rightLog);

	int countForQueryAll(@Param("searchKey") String searchKey, @Param("rightLog") String rightLog);

}
