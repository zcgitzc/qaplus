package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaRecommendFile;
import com.qaplus.entity.QaRecommendFileExample;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.cond.QueryRecommendFileCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.RecommendFileVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.mapper.QaRecommendFileMapperExt;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.RecommendFileService;
import com.qaplus.service.UserService;
import com.qaplus.utils.LongUtil;

@Service
public class RecommendFileServiceImpl implements RecommendFileService {
	@Resource
	private QaRecommendFileMapperExt recommendFileMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private AttachmentService attachmentService;

	@Cacheable(value="recommendFile")
	@Override
	public ResponseData<QaRecommendFile> queryQaRecommendFileForPage(Page page, QueryRecommendFileCond cond) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		return new ResponseData<QaRecommendFile>(recommendFileMapperExt.queryQaRecommendFileForPage(page, cond), 
				recommendFileMapperExt.countQaRecommendFileForPage(cond));
	}

	@SystemOperatorLog(description = "删除资料")
	@Override
	public int deleteRecommend(Long id) {
		QaRecommendFile file = recommendFileMapperExt.selectByPrimaryKey(id);
		if (CommonBoolean.Y.name().equals(file.getHasAttachment())) {
			attachmentService.deleteAttachmentById(Long.parseLong(file.getAttachmentId().toString()));
		}
		file.setIsDeleted(CommonBoolean.Y.name());
		return recommendFileMapperExt.updateByPrimaryKeySelective(file);
	}

	@Override
	public int updateRecommend(QaRecommendFile recommendFile) {
		// 删除原来附件
		QaRecommendFile oldRecommendFile = recommendFileMapperExt.selectByPrimaryKey(recommendFile.getId());
		if (CommonBoolean.Y.name().equals(oldRecommendFile.getHasAttachment())) {
			attachmentService.deleteAttachmentById(Long.parseLong(oldRecommendFile.getAttachmentId().toString()));
		}
		judgeRecommendFileHasAttach(recommendFile);
		return recommendFileMapperExt.updateByPrimaryKeySelective(recommendFile);
	}

	@SystemOperatorLog(description = "添加资料")
	@Override
	public int addRecommend(QaRecommendFile recommendFile) {
		judgeRecommendFileHasAttach(recommendFile);
		QaUser user = userService.getCurrUserBySession();
		recommendFile.setRecommendPerson(user.getId());
		return recommendFileMapperExt.insertSelective(recommendFile);
	}

	@Override
	public QaRecommendFile queryById(Long id) {
		return recommendFileMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public int countAllRecommend() {
		QaUser user = userService.getCurrUserBySession();
		QaRecommendFileExample example = new QaRecommendFileExample();
		example.createCriteria().andRecommendPersonEqualTo(user.getId());
		return recommendFileMapperExt.countByExample(example);
	}

	@Override
	public RecommendFileVo queryRecommendWithAttachById(Long id) {
		QaRecommendFile recommendFile=this.queryById(id);
		if(StringUtils.isEmpty(recommendFile.getHasAttachment()) || CommonBoolean.N.name().equals(recommendFile.getHasAttachment())){
			RecommendFileVo result=new RecommendFileVo();
			BeanUtils.copyProperties(recommendFile, result);
			return result;
		}
		return recommendFileMapperExt.queryRecommendWithAttachById(id);
	}
	
	/**
	 * 判断是否有附件
	 * @param recommendFile
	 */
	private void judgeRecommendFileHasAttach(QaRecommendFile recommendFile){
		if (LongUtil.isNotNull(recommendFile.getAttachmentId())) {
			recommendFile.setHasAttachment(CommonBoolean.Y.name());
		}
	}

}
