package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.entity.QaClass;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.mapper.QaClassMapperExt;
import com.qaplus.service.ClassService;
import com.qaplus.service.UserService;

@Service
public class ClassServiceImpl implements ClassService {
	@Resource
	private QaClassMapperExt classMapperExt;
	@Resource
	private UserService userService;

	@Cacheable(value = "classes")
	@Override
	public ResponseData<QaClass> queryAllClassForPage(Page page) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		return new ResponseData<QaClass>(classMapperExt.queryAllClassForPage(page), classMapperExt.countAllClassForPage());
	}

	@Override
	public void updateClass(QaClass clazz) {
		classMapperExt.updateByPrimaryKeySelective(clazz);
	}

	@SystemOperatorLog(description="添加班级")
	@Override
	public void addClass(QaClass clazz) {
		classMapperExt.insertSelective(clazz);
	}

	@Override
	public QaClass selectByPrimary(Long id) {
		return classMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public List<QaClass> queryMyClass() {
		QaUser user = userService.getCurrUserBySession();
		return classMapperExt.queryClassByUserId(user.getId());
	}

	@Override
	public List<QaClass> selectAllClasses() {
		return classMapperExt.selectByExample(null);
	}

	@Override
	public List<QaClass> queryClassByUserId(Long userId) {
		return classMapperExt.queryClassByUserId(userId);
	}

}
