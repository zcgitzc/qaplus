package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.entity.QaResources;
import com.qaplus.service.ResourcesService;
import com.qaplus.service.UserService;

@Controller
@RequestMapping("resource")
public class ResourceController extends SuperController {

	@Resource
	private ResourcesService resourceService;
	@Resource
	private UserService userService;

	//头部的导航
	@RequestMapping("query_my_resource")
	public List<QaResources> queryMyResources() {
		return resourceService.queryMyResources();
	}

	//首页中间的导航
	@RequestMapping("query_home_resource")
	public List<QaResources> queryHomeResources(HttpServletRequest request) {
		return resourceService.queryHomeCenterNav();
	}

}
