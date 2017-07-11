package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.QaStuHwAnswer;
import com.qaplus.entity.QaStuHwDetail;
import com.qaplus.entity.QaStuHwQuestion;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuHomeworkVo;
import com.qaplus.mapper.QaStuHomeworkMapperExt;
import com.qaplus.mapper.QaStuHwDetailMapperExt;
import com.qaplus.mapper.QaStuHwQuestionMapperExt;
import com.qaplus.service.HomeworkAnswerService;
import com.qaplus.service.HomeworkService;
import com.qaplus.service.UserService;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.SuperDate;

@Service
public class HomeworkServiceImpl implements HomeworkService {

	@Resource
	private QaStuHomeworkMapperExt homeworkMapperExt;
	@Resource
	private QaStuHwDetailMapperExt homeworkDetailMapperExt;
	@Resource
	private QaStuHwQuestionMapperExt homeworkQuestionMapperExt;
	@Resource
	private HomeworkAnswerService homeworkAnswerService;
	@Resource
	private UserService userSerivce;
	private static final String DELIMITER = "_";

	@SystemOperatorLog(description = "布置家作")
	@Override
	public int addHomework(String title, String commitDate, String stuIds, String ids) {
		QaUser user = userSerivce.getCurrUserBySession();
		QaStuHomework homework = new QaStuHomework();
		homework.setTitle(title);

		homework.setCreatePerson(user.getUsername());

		homework.setCommitDate(SuperDate.parse(commitDate, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		homeworkMapperExt.insertSelective(homework);
		// 家庭作业-学生
		String[] stuArr = stuIds.split(",");
		for (String stuId : stuArr) {
			QaStuHwDetail homeworkDetail = new QaStuHwDetail();
			// 去除前缀
			stuId = stuId.substring(stuId.indexOf(DELIMITER) + 1, stuId.length());

			homeworkDetail.setStuId(Long.parseLong(stuId));
			homeworkDetail.setIsCommit(CommonBoolean.N.name());
			homeworkDetail.setHomeworkId(homework.getId());

			homeworkDetailMapperExt.insertSelective(homeworkDetail);
		}

		// 家庭作业-问题
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			QaStuHwQuestion record = new QaStuHwQuestion();
			record.setHomeworkId(homework.getId());
			record.setQuestionId(Long.parseLong(id));
			homeworkQuestionMapperExt.insertSelective(record);
		}

		for (String stuId : stuArr) {
			for (String id : idArr) {
				// 去除前缀
				stuId = stuId.substring(stuId.indexOf(DELIMITER) + 1, stuId.length());
				// 家庭作业-学生答案
				QaStuHwAnswer homeworkAnswer = new QaStuHwAnswer();
				homeworkAnswer.setHomeworkId(homework.getId());
				homeworkAnswer.setQuestionId(Long.parseLong(id));
				homeworkAnswer.setStuId(Long.parseLong(stuId));
				homeworkAnswerService.addHomeworkAnswer(homeworkAnswer);
			}
		}

		return 1;
	}

	@Override
	public int insertSelective(QaStuHomework record) {
		return homeworkMapperExt.insertSelective(record);
	}

	@Override
	public List<StuHomeworkVo> selectMyHomework() {
		QaUser user = userSerivce.getCurrUserBySession();
		return homeworkMapperExt.selectMyHomework(user.getId());
	}

	@Override
	public ResponseData<QaStuHomework> queryHomeworkForPage(QaStuHomework record, Page page) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		return new ResponseData<QaStuHomework>(homeworkMapperExt.queryHomeworkForPage(record, page), homeworkMapperExt.countHomeworkForPage(record));
	}

	@Override
	public int deleteHomework(Long id) {
		QaStuHomework homework = homeworkMapperExt.selectByPrimaryKey(id);
		homework.setIsDeleted(CommonBoolean.Y.name());
		return homeworkMapperExt.updateByPrimaryKeySelective(homework);
	}

	@Override
	public QaStuHomework queryById(Long id) {
		return homeworkMapperExt.selectByPrimaryKey(id);
	}

}
