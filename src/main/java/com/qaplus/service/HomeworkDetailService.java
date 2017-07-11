package com.qaplus.service;

import com.qaplus.entity.QaStuHwDetail;
import com.qaplus.entity.vo.HomeworkDetailVo;
import com.qaplus.entity.vo.RemarkHomeworkVo;


public interface HomeworkDetailService {
	int countMyHomework();
	int updateByPrimaryKey(QaStuHwDetail detail);
	//查看学生家庭作业
	QaStuHwDetail selectByHomeworkIdAndStuId(Long homeworkId,Long stuId);
	
	//查看家庭作业明细：多少人交了作业、多少人没有交、作业有哪些问题
	HomeworkDetailVo queryHomeworkDetail(Long homeworkId);
	
	//老师查看学生的家庭作业
	RemarkHomeworkVo teacherRemarkHomework(Long stuId, Long homeworkId);
}
