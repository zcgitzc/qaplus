package com.qaplus.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaSQuestion;
import com.qaplus.entity.cond.QueryQuestionCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.StuQuestionVo;

@Repository
public interface QaSQuestionMapperExt extends QaSQuestionMapper {
	List<QaSQuestion> querySQuestionForPage(@Param(value = "page") Page page, @Param(value = "cond") QueryQuestionCond cond, @Param(value = "type") String type);

	int countSQuestionForPage(@Param(value = "cond") QueryQuestionCond cond, @Param(value = "type") String type);

	List<Map<Object, Object>> queryForSolve();

	List<Map<Object, Object>> queryForCategory();

	List<Map<Object, Object>> queryForDate();

	List<QaSQuestion> queryIsDeletedQuestion(@Param("userId") Long userId);

	// MySql datetime类型是可以直接和 java 中 string 类型比较的
	Map<Object, Object> queryQuestionCountOneDay(@Param("date") String date, @Param("userId") Long userId);

	List<QaSQuestion> queryUnsolveQuestion(@Param("userId") Long id);

	StuQuestionVo queryStuQuestionAndAttachById(Long id);

}