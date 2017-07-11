package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuHomeworkVo;

public interface HomeworkService {
	int insertSelective(QaStuHomework record);
	
	int addHomework(String title,String commitDate,String stuIds,String ids);
	
	List<StuHomeworkVo> selectMyHomework();
	
	ResponseData<QaStuHomework> queryHomeworkForPage(QaStuHomework record,Page page);
	
	int deleteHomework(Long id);
	
	QaStuHomework queryById(Long id);

}
