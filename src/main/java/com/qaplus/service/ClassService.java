package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaClass;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;

public interface ClassService {
	ResponseData<QaClass> queryAllClassForPage(Page page);

	void updateClass(QaClass clazz);

	void addClass(QaClass clazz);

	QaClass selectByPrimary(Long id);

	List<QaClass> queryMyClass();

	List<QaClass> selectAllClasses();
	
	List<QaClass> queryClassByUserId(Long userId);
}
