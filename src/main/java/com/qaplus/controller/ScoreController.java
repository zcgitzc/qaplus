package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.entity.vo.ScoreVo;
import com.qaplus.service.ScoreService;

@Controller
@RequestMapping("score")
public class ScoreController extends SuperController {
	@Resource
	private ScoreService scoreService;
	
	@RequestMapping("queryStuScores")
	public List<ScoreVo> queryStuScores(String title) {
		return scoreService.queryStuScores(title);
	}
	
}
