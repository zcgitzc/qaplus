package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaPaperStu;
import com.qaplus.entity.vo.UserVo;

public interface PaperStudentService {
	void add(QaPaperStu paperStudent);

	QaPaperStu queryByPaperIdAndStuId(Long paperId,Long stuId);

	void update(QaPaperStu paperStudent);
	
	List<QaPaperStu> queryAllUnSumit(Long paperId);
	
	List<QaPaperStu> queryAllByPaperId(Long paperId);

	List<UserVo> queryAllStusByPaperId(Long paperId);

}
