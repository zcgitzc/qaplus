package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaBoard;

public interface BoardService {
	List<QaBoard> selectAllMyBoard();

	void addBoard(String content,String importantFlag,String keepTop,String endTime, String startTime, String stuIds);
}
