package com.qaplus.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.entity.QaSystemConstant;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.service.SystemConstantService;

@Controller
@RequestMapping("systemConstant")
public class SystemConstantController extends SuperController {
	@Resource
	private SystemConstantService systemConstantService;

	@RequestMapping("queryForPage")
	public ResponseData<QaSystemConstant> queryForPage(Page page, String searchKey) {
		return systemConstantService.queryForPage(page, searchKey);
	}

	@RequestMapping("queryByCategorys")
	public List<QaSystemConstant> queryByCategorys(String[] categorys) {
		return systemConstantService.queryByCategorys(Arrays.asList(categorys));
	}

}
