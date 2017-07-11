package com.qaplus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaRecommendFile;
import com.qaplus.entity.cond.QueryRecommendFileCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.RecommendFileVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.RecommendFileService;

@Controller
@RequestMapping("recommend")
public class RecommendFileController extends SuperController {
	@Resource
	private RecommendFileService recommendFileService;
	@Resource
	private AttachmentService attachmentService;

	@RequestMapping("recommend_file")
	public ResponseData<QaRecommendFile> queryRecommendFileForPage(Page page, QueryRecommendFileCond cond) {
		return recommendFileService.queryQaRecommendFileForPage(page, cond);
	}

	@RequestMapping("count_recommend_file")
	public int countAllRecommend() {
		return recommendFileService.countAllRecommend();
	}

	@RequestMapping("del_recommend")
	public BaseVoid delRecommend(Long id) {
		recommendFileService.deleteRecommend(id);
		return new BaseVoid();
	}

	@RequestMapping("query_by_id")
	public QaRecommendFile queryRecommendById(Long id) {
		return recommendFileService.queryRecommendWithAttachById(id);
	}

	@RequestMapping("query_recommend_with_attach")
	public RecommendFileVo queryRecommendWithAttachById(Long id) {
		return recommendFileService.queryRecommendWithAttachById(id);
	}

	@RequestMapping("update_recommend")
	public BaseVoid updateRecommend(QaRecommendFile recommendFile) {
		recommendFileService.updateRecommend(recommendFile);
		return new BaseVoid();
	}

	@RequestMapping("add_recommend")
	public BaseVoid addRecommend(QaRecommendFile file) {
		recommendFileService.addRecommend(file);
		return new BaseVoid();
	}

}
