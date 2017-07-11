package com.qaplus.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaBoard;

@Repository
public interface QaBoardMapperExt extends QaBoardMapper {
	List<QaBoard> selectAllMyBoard(Long id);
	QaBoard selectMaxKeepTop();
}