package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaBoard;
import com.qaplus.entity.QaBoardUser;
import com.qaplus.entity.QaUser;
import com.qaplus.mapper.QaBoardMapperExt;
import com.qaplus.service.BoardService;
import com.qaplus.service.BoardUserService;
import com.qaplus.service.UserService;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.SuperDate;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private UserService userService;
	@Resource
	private QaBoardMapperExt boardMapperExt;
	@Resource
	private BoardUserService boardUserService;
	
	private static final String DELIMITER = "_";
	
	@Override
	public List<QaBoard> selectAllMyBoard() {
		QaUser user=userService.getCurrUserBySession();
		return boardMapperExt.selectAllMyBoard(user.getId());
	}
	
	@Override
	public void addBoard(String content,String importantFlag,String keepTopFlag,String endTime, String startTime,String stuIds) {
		QaBoard board=new QaBoard();
		board.setContent(content);
		board.setImportantFlag(importantFlag);
		if(CommonBoolean.Y.name().equals(keepTopFlag)){
			QaBoard maxKeepBoard=boardMapperExt.selectMaxKeepTop();
			if(maxKeepBoard==null){
				board.setKeepTop(1);
			}else{
				board.setKeepTop(maxKeepBoard.getKeepTop()+1);
			}
		}
		board.setEndTime(SuperDate.parse(endTime, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		board.setStartTime(SuperDate.parse(startTime, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		boardMapperExt.insertSelective(board);
		
		String[] stuArr = stuIds.split(",");
		for (String stuId : stuArr) {
			// 去除前缀
			stuId = stuId.substring(stuId.indexOf(DELIMITER) + 1, stuId.length());
			QaBoardUser boardUser=new QaBoardUser();
			boardUser.setBoardId(board.getId());
			boardUser.setUserId(Long.parseLong(stuId));
			boardUserService.addUserBoard(boardUser);
		}
	}
}
