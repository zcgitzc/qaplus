package com.qaplus.service;

import com.qaplus.entity.QaRecommendFile;
import com.qaplus.entity.cond.QueryRecommendFileCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.RecommendFileVo;
import com.qaplus.entity.vo.ResponseData;

public interface RecommendFileService {
	ResponseData<QaRecommendFile> queryQaRecommendFileForPage(Page page,QueryRecommendFileCond cond);
	int deleteRecommend(Long id);
	int updateRecommend(QaRecommendFile recommendFile);
	int addRecommend(QaRecommendFile recommendFile);
	QaRecommendFile queryById(Long id);
	int countAllRecommend();
	RecommendFileVo queryRecommendWithAttachById(Long id);
}
