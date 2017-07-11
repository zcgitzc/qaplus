package com.qaplus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaExamQuestionItem;
import com.qaplus.service.ExamQuestionItemService;

@Controller
@RequestMapping("examQuestionItem")
public class ExamQuestionItemController extends SuperController {
	@Resource
	private ExamQuestionItemService examQuestionItemService;


	@RequestMapping("updateById")
	public BaseVoid updateById(QaExamQuestionItem item) {
		examQuestionItemService.updateById(item);
		return new BaseVoid();
	}

}
