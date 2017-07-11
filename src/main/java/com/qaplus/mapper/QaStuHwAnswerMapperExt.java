package com.qaplus.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qaplus.entity.vo.MarkingHomeworkVo;

@Repository
public interface QaStuHwAnswerMapperExt extends QaStuHwAnswerMapper {
	List<MarkingHomeworkVo> markingStuHomework(Long stuId,Long homeworkId);
}