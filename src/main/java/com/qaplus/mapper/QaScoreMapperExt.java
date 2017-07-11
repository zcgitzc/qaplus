package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaScore;

@Repository
public interface QaScoreMapperExt extends QaScoreMapper {
	void updateStuPaperScore(@Param("paperId") Long paperId, @Param("stuId") Long stuId, @Param("score") int score);

	List<QaScore> queryTopThree(@Param("paperId") Long paperId);

}