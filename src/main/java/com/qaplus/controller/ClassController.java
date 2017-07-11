package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.constant.BaseVoid;
import com.qaplus.constant.ErrorCode;
import com.qaplus.entity.QaClass;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.service.ClassService;

@Controller
@RequestMapping("class")
public class ClassController extends SuperController {
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);

	@Resource
	private ClassService classService;

	@RequestMapping("select_all_class")
	public ResponseData<QaClass> queryAllClassForPage(Page page) {
		try {
			return classService.queryAllClassForPage(page);
		} catch (Exception e) {
			logger.error("查看所有的班级出错啦", e);
			return new ResponseData<QaClass>(ErrorCode.FAUILURE, ErrorCode.FAUILURE.getDesc(), null, true);
		}
	}

	@RequestMapping("query_my_class")
	public List<QaClass> queryMyClass() {
		return classService.queryMyClass();
	}

	@SystemOperatorLog(description = "修改班级")
	@RequestMapping("update_class")
	public BaseVoid updateClass(QaClass clazz) {
		classService.updateClass(clazz);
		return new BaseVoid();
	}

	@SystemOperatorLog(description = "增加班级")
	@RequestMapping("add_class")
	public BaseVoid addClass(QaClass clazz) {
		//TODO 是否要指定老师
		classService.addClass(clazz);
		return new BaseVoid();
	}
}
