package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaBoard;
import com.qaplus.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController extends SuperController {
	@Resource
	private BoardService boardService;

	@RequestMapping("select_all_my_board")
	public List<QaBoard> selectAllMyBoard() {
		return boardService.selectAllMyBoard();
	}

	@RequestMapping("add_board")
	public BaseVoid addBoard(String content, String importantFlag, String keepTopFlag, String endTime, String startTime, String stuIds) {
		boardService.addBoard(content, importantFlag, keepTopFlag, endTime, startTime, stuIds);
		return new BaseVoid();
	}

}
