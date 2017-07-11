package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.cond.QueryQuestionCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.TeacherQuestionVo;

@Repository
public interface QaTQuestionMapperExt extends QaTQuestionMapper{
	List<QaTQuestion> queryTQuestionForPage(@Param(value = "page") Page page,@Param(value="cond") QueryQuestionCond cond);

	int countTQuestionForPage(@Param(value="cond") QueryQuestionCond cond);

	List<QaTQuestion> queryMyHomeworkQuestion(@Param("homeworkId")Long homeworkId,@Param("stuId") Long stuId);

	//老师问题及问题附件信息
	TeacherQuestionVo queryTeaQuestionById(Long id);
	
	//老师问题及问题答案附件信息
	TeacherQuestionVo queryTeaAnswerById(Long id);
	
}
