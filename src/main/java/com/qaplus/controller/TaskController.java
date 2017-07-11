package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaTask;
import com.qaplus.service.TaskService;

@Controller
@RequestMapping("task")
@ResponseBody
public class TaskController extends SuperController {
	@Resource
	private TaskService taskService;

	@RequestMapping("select_my_task")
	private List<QaTask> selectMyTask(HttpServletRequest request) {
		return taskService.queryMyTask();
	}

	@RequestMapping("agree")
	private BaseVoid agree(QaTask qaTask) {
		taskService.agree(qaTask);
		return new BaseVoid();
	}

	@RequestMapping("reject")
	private BaseVoid reject(QaTask qaTask) {
		taskService.reject(qaTask);
		return new BaseVoid();
	}

}
