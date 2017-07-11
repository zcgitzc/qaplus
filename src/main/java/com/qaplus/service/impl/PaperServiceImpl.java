package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.DiffStage;
import com.qaplus.constant.ExamStatus;
import com.qaplus.constant.PaperStatus;
import com.qaplus.constant.QCategory;
import com.qaplus.controller.ClassController;
import com.qaplus.entity.QaExamErrorQuestions;
import com.qaplus.entity.QaExamQuestion;
import com.qaplus.entity.QaPaper;
import com.qaplus.entity.QaPaperExample;
import com.qaplus.entity.QaPaperStu;
import com.qaplus.entity.QaPaperStuDetail;
import com.qaplus.entity.QaScore;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.ExamQuestionItemVo;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.PaperVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuStartExam;
import com.qaplus.mapper.QaPaperMapperExt;
import com.qaplus.mapper.QaPaperStuDetailMapperExt;
import com.qaplus.mapper.QaPaperStuMapperExt;
import com.qaplus.service.BoardService;
import com.qaplus.service.ExamErrorQuestionsService;
import com.qaplus.service.ExamQuestionItemService;
import com.qaplus.service.ExamQuestionService;
import com.qaplus.service.PaperService;
import com.qaplus.service.PaperStudentDetailService;
import com.qaplus.service.PaperStudentService;
import com.qaplus.service.ScoreService;
import com.qaplus.service.UserService;
import com.qaplus.sql.batch.BatchSupport;
import com.qaplus.sql.batch.MapperIdConstant;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.LongUtil;
import com.qaplus.utils.SuperDate;

@Service
public class PaperServiceImpl implements PaperService {
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	@Resource
	private UserService userService;
	@Resource
	private ExamQuestionService examQuestionService;
	@Resource
	private QaPaperMapperExt paperMapperExt;
	@Resource
	private PaperStudentService paperStudentService;
	@Resource
	private PaperStudentDetailService paperStudentDetailService;
	@Resource
	private ScoreService scoreService;
	@Resource
	private ExamQuestionItemService examQuestionItemService;
	@Resource
	private BoardService boardService;
	@Resource
	private ExamErrorQuestionsService errorQuestionsService;

	private static final String SEPARATOR = ",";

	@SystemOperatorLog(description = "制作试卷")
	@Override
	public PaperVo makePaper(PaperVo paper) {
		// 简单的校验
		validateParam(paper);
		paper.setExamDate(SuperDate.parse(paper.getExamTime(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		paper.setDiffStage(DiffStage.EASY.name());
		PaperStatus status = generatePaperStatus(paper);
		if (PaperStatus.STARTED.equals(status)) {
			throw new RuntimeException("考试时间输入有误");
		}
		paper.setPaperStatus(status.name());
		paper.setPaperPerson(userService.getCurrUserBySession().getId());
		Long examLong = (long) (paper.getExamLong() * 60 * 1000);
		if (SuperDate.now().getTime() > paper.getExamDate().getTime() + examLong) {
			throw new RuntimeException("考试时间设置有问题，请检查");
		} else {
			paper.setIsEffect(CommonBoolean.Y.name());
		}
		paper.getExamDate().getTime();
		fillExamQuestionForPaper(paper);
		publishPaperToStus(paper);
		return paper;
	}

	/**
	 * 给试卷添加问题
	 * 
	 * @param paper
	 */
	private void fillExamQuestionForPaper(PaperVo paper) {
		List<QaExamQuestion> resultQuestions = new ArrayList<QaExamQuestion>();

		List<QaExamQuestion> easyQuestions = new ArrayList<QaExamQuestion>();
		List<QaExamQuestion> middleQuestions = new ArrayList<QaExamQuestion>();
		List<QaExamQuestion> difficultQuestions = new ArrayList<QaExamQuestion>();
		// 根据用户所选，找到相应的试题
		if (QCategory.MIX.equals(QCategory.valueOf(paper.getPaperCategory()))) {
			// 综合试卷
			easyQuestions = examQuestionService.queryStageQuestions(DiffStage.EASY, QCategory.OTHER);
			middleQuestions = examQuestionService.queryStageQuestions(DiffStage.MIDDLE, QCategory.OTHER);
			difficultQuestions = examQuestionService.queryStageQuestions(DiffStage.DIFFICULT, QCategory.OTHER);
		} else {
			// 某类试题测试
			easyQuestions = examQuestionService.queryStageQuestions(DiffStage.EASY, QCategory.valueOf(paper.getPaperCategory()));
			middleQuestions = examQuestionService.queryStageQuestions(DiffStage.MIDDLE, QCategory.valueOf(paper.getPaperCategory()));
			difficultQuestions = examQuestionService.queryStageQuestions(DiffStage.DIFFICULT, QCategory.valueOf(paper.getPaperCategory()));
		}

		List<QaExamQuestion> randomEasyQuestions = getRandomQuestion(easyQuestions, paper.getEasy());
		List<QaExamQuestion> randomMiddleQuestions = getRandomQuestion(middleQuestions, paper.getMiddle());
		List<QaExamQuestion> randomDifficultQuestions = getRandomQuestion(difficultQuestions, paper.getDifficult());

		int easyScore = 0;
		int middleScore = 0;
		int difficultScore = 0;

		for (QaExamQuestion qaExamQuestion : randomEasyQuestions) {
			easyScore += qaExamQuestion.getScore();
		}
		for (QaExamQuestion qaExamQuestion : randomMiddleQuestions) {
			middleScore += qaExamQuestion.getScore();
		}
		for (QaExamQuestion qaExamQuestion : randomDifficultQuestions) {
			difficultScore += qaExamQuestion.getScore();
		}
		// 制作试卷
		// TODO 总分暂时直接相加（不让前端选择，方便处理）
		paper.setTotalScore(easyScore + middleScore + difficultScore);
		resultQuestions.addAll(randomEasyQuestions);
		resultQuestions.addAll(randomMiddleQuestions);
		resultQuestions.addAll(randomDifficultQuestions);

		StringBuffer questionIds = new StringBuffer();
		for (QaExamQuestion qaExamQuestion : resultQuestions) {
			questionIds = questionIds.append(qaExamQuestion.getId() + SEPARATOR);
		}
		paper.setQuestionIds(questionIds.toString());
		paperMapperExt.insertSelective(paper);
	}

	/**
	 * 发布试卷给学生做，同时添加公告
	 * 
	 * @param paper
	 */
	private void publishPaperToStus(PaperVo paper) {
		QaUser user = userService.getCurrUserBySession();
		// 发布试卷给学生做
		QaPaperStu paperStudent = null;
		QaPaperStuDetail paperStudentDetail = null;

		String[] stuArr = null;
		if (StringUtils.isNotEmpty(paper.getStuIds())) {
			stuArr = paper.getStuIds().split(",");
		} else if (LongUtil.isNotNull(paper.getClassId())) {
			List<QaUser> stus = userService.queryAllUserByClassId(paper.getClassId(), CommonBoolean.Y, CommonBoolean.N, null);
			stuArr = new String[stus.size()];
			String stuIds = "";
			for (int i = 0; i < stus.size(); i++) {
				stuArr[i] = stus.get(i).getId().toString();
				stuIds += stus.get(i).getId().toString() + SEPARATOR;
			}
			paper.setStuIds(stuIds);
		} else {
			throw new RuntimeException("请选择考试人员  1)指定班级   2)指定学生");
		}
		// 发公告
		String now = SuperDate.format(SuperDate.now(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS);
		String boardContent = "老师：" + user.getName() + "，在：" + now + " 发布了试卷（" + paper.getPaperTitle() + "）给你做，考试时间：" + paper.getExamTime() + "。请注意！！！";
		boardService.addBoard(boardContent, CommonBoolean.Y.name(), CommonBoolean.Y.name(), paper.getExamTime(), now, paper.getStuIds());

		for (String stuId : stuArr) {
			paperStudent = new QaPaperStu();
			paperStudent.setExamStatus(ExamStatus.UN_EXAM.name());
			paperStudent.setIsSubmit(CommonBoolean.N.name());
			paperStudent.setPaperId(paper.getId());
			paperStudent.setStuId(Long.parseLong(stuId));
			paperStudentService.add(paperStudent);
			for (String questionId : paper.getQuestionIds().split(SEPARATOR)) {
				paperStudentDetail = new QaPaperStuDetail();
				paperStudentDetail.setPaperId(paper.getId());
				paperStudentDetail.setStuId(Long.parseLong(stuId));
				paperStudentDetail.setExamQuestionId(Long.parseLong(questionId));
				paperStudentDetailService.add(paperStudentDetail);
			}
		}
	}

	private <T> List<T> getRandomQuestion(List<T> questions, int count) {
		if (questions.size() < count) {
			throw new RuntimeException("考试试题题库题目不够，请重新选择");
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<T> randomQuestions = new ArrayList<T>();
		while (map.size() < count) {
			int random = (int) (Math.random() * questions.size());
			if (!map.containsKey(random)) {
				map.put(random, "");
				randomQuestions.add(questions.get(random));
			}
		}
		return randomQuestions;
	}

	private void validateParam(PaperVo paper) {
		if (null != paper) {
			if (paper.getQuestionAmount() != paper.getEasy() + paper.getMiddle() + paper.getDifficult()) {
				throw new RuntimeException("题目数量不等");
			}
			if (StringUtils.isEmpty(paper.getStuIds()) && LongUtil.isNull(paper.getClassId())) {
				throw new RuntimeException("没有选择参与考试的学生");
			}
			if (StringUtils.isEmpty(paper.getExamTime())) {
				throw new RuntimeException("请输入考试时间");
			}
		}
	}

	@Override
	public List<ExamQuestionVo> preview(Long paperId) {
		QaPaper paper = paperMapperExt.selectByPrimaryKey(paperId);
		String[] tempIds = paper.getQuestionIds().split(SEPARATOR);
		List<Long> ids = new ArrayList<Long>();
		for (String idStr : tempIds) {
			ids.add(Long.parseLong(idStr));
		}
		return examQuestionService.queryByIds(ids);
	}

	@Override
	public StuStartExam startExam(Long paperId, Long stuId) {
		StuStartExam startExam = new StuStartExam();
		// 检查试卷时间
		QaPaper paper = paperMapperExt.selectByPrimaryKey(paperId);
		if (paper == null) {
			throw new RuntimeException("试卷不存在，请联系老师检查");
		}
		Long examLong = (long) (paper.getExamLong() * 60 * 1000);
		Long nowTime = SuperDate.now().getTime();
		startExam.setPaperId(paperId);
		QaPaperStu paperStu = paperStudentService.queryByPaperIdAndStuId(paperId, stuId);

		if (nowTime > paper.getExamDate().getTime() + examLong || (paperStu != null && paperStu.getIsSubmit().equals(CommonBoolean.Y.name()))) {
			// 考完试，查看试题
			return queryStuPaper(paperId, stuId);
		} else if (nowTime > paper.getExamDate().getTime() && nowTime < paper.getExamDate().getTime() + examLong && CommonBoolean.Y.name().equals(paper.getIsEffect())) {
			if (paperStu == null || paperStu.getExamStatus().equals(ExamStatus.EXAMED.name())) {
				throw new RuntimeException("当前学生没有考试，请联系老师确认");
			}
			List<ExamQuestionVo> examQuestions = getPaperQuestions(paper);
			startExam.setQuestions(examQuestions);
			paperStu.setExamStatus(ExamStatus.EXAMING.name());
			paperStudentService.update(paperStu);
			startExam.setLeftTime((paper.getExamDate().getTime() + examLong) - nowTime);
			return startExam;
		} else {
			throw new RuntimeException("还没有到考试时间，考试时间为：" + SuperDate.format(paper.getExamDate(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		}
	}

	/**
	 * 得到试卷的试题
	 * 
	 * @param paper
	 * @return
	 */
	private List<ExamQuestionVo> getPaperQuestions(QaPaper paper) {
		List<ExamQuestionVo> examQuestions = this.preview(paper.getId());
		if (CommonBoolean.Y.name().equals(paper.getUpsetQuestion())) {
			// 打乱试题顺序
			examQuestions = getRandomQuestion(examQuestions, examQuestions.size());
		}

		if (CommonBoolean.Y.name().equals(paper.getUpsetItem())) {
			// 打乱选项顺序
			for (ExamQuestionVo examQuestionVo : examQuestions) {
				examQuestionVo.setCanReadNote(CommonBoolean.N.name());
				examQuestionVo.setItems(getRandomQuestion(examQuestionVo.getItems(), examQuestionVo.getItems().size()));
			}
		}
		return examQuestions;
	}

	@Override
	public List<QaPaper> queryAllEffectPaper() {
		QaPaperExample example = new QaPaperExample();
		example.createCriteria().andIsEffectEqualTo(CommonBoolean.Y.name());
		return paperMapperExt.selectByExample(example);
	}

	@Override
	public void update(QaPaper paper) {
		paperMapperExt.updateByPrimaryKeySelective(paper);
	}

	@Override
	public StuStartExam endExam(StuStartExam exam) {
		Long stuId = userService.getCurrUserBySession().getId();
		// 检查试卷是否有效（时间有没有过期）
		QaPaper paper = paperMapperExt.selectByPrimaryKey(exam.getPaperId());
		if (paper.getIsEffect().equals(CommonBoolean.N.name())) {
			throw new RuntimeException("试卷已经过期，超过了考试时间");
		}
		// 修改考试状态
		QaPaperStu paperStu = paperStudentService.queryByPaperIdAndStuId(exam.getPaperId(), stuId);
		paperStu.setExamStatus(ExamStatus.EXAMED.name());
		paperStu.setIsSubmit(CommonBoolean.Y.name());

		paperMapperExt.updateByPrimaryKeySelective(paper);
		paperStudentService.update(paperStu);

		List<ExamQuestionVo> questions = exam.getQuestions();

		int totalScore = 0;
		for (ExamQuestionVo examQuestionVo : questions) {
			String choiceItem = "";
			String rightItem = "";

			for (ExamQuestionItemVo item : examQuestionVo.getItems()) {
				if (CommonBoolean.Y.name().equals(item.getIsUserChoice())) {
					choiceItem += item.getId() + SEPARATOR;
				}
			}
			for (ExamQuestionItemVo item : examQuestionVo.getItems()) {
				if (CommonBoolean.Y.name().equals(item.getIsRightItem())) {
					rightItem += item.getId() + SEPARATOR;
				}
			}

			if (choiceItem.equals(rightItem)) {
				logger.info(String.format("questionId:%s,choiceItem:%s,rightItem:%s,", examQuestionVo.getId(), choiceItem, rightItem));
				totalScore += examQuestionVo.getScore();
				addRightQuestion(examQuestionVo);
			} else {
				addErrorQuestion(examQuestionVo);
			}

			QaPaperStuDetail detail = paperStudentDetailService.queryByPaperIdAndQuestionId(exam.getPaperId(), examQuestionVo.getId(), stuId);
			if (detail != null) {
				detail.setChoiceItem(choiceItem);
				paperStudentDetailService.update(detail);
			}
			examQuestionVo.setCanReadNote(CommonBoolean.Y.name());
		}

		// 修改分数
		QaScore score = scoreService.queryByPaperIdAndStuId(exam.getPaperId(), stuId);
		if (score == null) {
			QaScore scoreAdd = new QaScore();
			scoreAdd.setPaperId(exam.getPaperId());
			scoreAdd.setStuId(stuId);
			scoreAdd.setScore(totalScore);
			scoreService.add(scoreAdd);
		} else {
			scoreService.updateStuPaperScore(exam.getPaperId(), stuId, totalScore);
		}
		exam.setTotalScore(totalScore);
		exam.setLeftTime(0L);
		return exam;
	}

	private void addErrorQuestion(ExamQuestionVo examQuestionVo) {
		// 做正确一题目
		List<QaExamErrorQuestions> errors = errorQuestionsService.queryByStuIdAndQuestionId(userService.getCurrUserBySession().getId(), examQuestionVo.getId());
		if (CollectionUtils.isEmpty(errors)) {
			QaExamErrorQuestions errorQuestions = new QaExamErrorQuestions();
			errorQuestions.setStuId(userService.getCurrUserBySession().getId());
			errorQuestions.setQuestionId(examQuestionVo.getId());
			errorQuestions.setErrorCount(NumberUtils.INTEGER_ONE);
			errorQuestions.setErrorRange(NumberUtils.INTEGER_ONE);
			errorQuestionsService.add(errorQuestions);
		} else if (errors.size() > 0) {
			QaExamErrorQuestions error = errors.get(0);
			error.setErrorCount(error.getErrorCount() + 1);
			errorQuestionsService.updateById(error);
		}
	}

	private void addRightQuestion(ExamQuestionVo examQuestionVo) {
		// 做正确一题目
		QaExamErrorQuestions errorQuestions = new QaExamErrorQuestions();
		errorQuestions.setStuId(userService.getCurrUserBySession().getId());
		errorQuestions.setQuestionId(examQuestionVo.getId());
		errorQuestions.setErrorCount(NumberUtils.INTEGER_ZERO);
		errorQuestions.setErrorRange(NumberUtils.INTEGER_ONE);
		errorQuestionsService.add(errorQuestions);
	}

	@Override
	public int getPaperAvg(Long paperId) {
		List<QaScore> scores = scoreService.queryAllByPaperId(paperId);
		if (CollectionUtils.isEmpty(scores)) {
			return 0;
		}
		int totalScore = 0;
		for (QaScore score : scores) {
			totalScore += score.getScore();
		}
		return totalScore / scores.size();
	}

	@Override
	public List<QaPaper> queryAll() {
		return paperMapperExt.selectByExample(new QaPaperExample());
	}

	@Override
	public ResponseData<PaperVo> queryAllPaperForPage(Page page, String[] categorys, String title, Long my, String[] status) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		List<PaperVo> papers = paperMapperExt.queryAllPaperForPage(page, categorys, title, my, status);
		for (PaperVo paperVo : papers) {
			paperVo.setAvgScore(this.getPaperAvg(paperVo.getId()));
			List<QaScore> stuScores = scoreService.queryTopThree(paperVo.getId());
			String content = "";
			for (QaScore qaScore : stuScores) {
				if (qaScore.getScore() != 0) {
					QaUser user = userService.queryById(qaScore.getStuId());
					content += user.getName() + "(" + qaScore.getScore() + "分)" + "、";
				}
			}
			paperVo.setTopThree(content);
		}
		int totalCount = paperMapperExt.countForQueryAll(categorys, title, my, status);
		return new ResponseData<PaperVo>(papers, totalCount);
	}

	@Override
	public PaperStatus generatePaperStatus(QaPaper paper) {
		if (SuperDate.now().getTime() < paper.getExamDate().getTime()) {
			return PaperStatus.UN_START;
		} else if (SuperDate.now().getTime() > paper.getExamDate().getTime() && SuperDate.now().getTime() < (paper.getExamDate().getTime() + paper.getExamLong() * 60 * 1000)) {
			return PaperStatus.STARTING;
		} else if (SuperDate.now().getTime() > (paper.getExamDate().getTime() + paper.getExamLong() * 60 * 1000)) {
			return PaperStatus.STARTED;
		}
		return null;
	}

	@Override
	public StuStartExam queryStuPaper(Long paperId, Long stuId) {
		StuStartExam startExam = new StuStartExam();
		// 查看学生是否已经结束考试
		QaPaperStu paperStu = paperStudentService.queryByPaperIdAndStuId(paperId, stuId);
		if (!ExamStatus.EXAMED.name().equals(paperStu.getExamStatus())) {
			throw new RuntimeException("学生还没有提交试卷，请等待学生提交，或者考试时间到，系统强制为学生提交试卷！！！");
		}
		QaPaper paper = new QaPaper();
		paper.setId(paperId);
		// 老师阅卷时候不打乱试题、选项顺序
		paper.setUpsetItem(CommonBoolean.N.name());
		paper.setUpsetItem(CommonBoolean.N.name());
		List<ExamQuestionVo> examQuestions = getPaperQuestions(paper);
		// 考试时间结束、查看试卷答案
		QaScore score = scoreService.queryByPaperIdAndStuId(paperId, stuId);
		startExam.setLeftTime(0L);
		startExam.setTotalScore(score == null ? 0 : score.getScore());
		startExam.setQuestions(examQuestions);
		startExam.setPaperId(paperId);
		QaPaper dbPaper = paperMapperExt.selectByPrimaryKey(paperId);
		startExam.setPaperName(dbPaper.getPaperTitle());
		startExam.setPaperTotalScore(dbPaper.getTotalScore());
		QaUser user = userService.queryById(stuId);
		startExam.setStuName(user.getName());
		// 得到用户选择的选项
		for (ExamQuestionVo examQuestionVo : examQuestions) {
			examQuestionVo.setCanReadNote(CommonBoolean.Y.name());
			QaPaperStuDetail paperStuDetail = paperStudentDetailService.queryByPaperIdAndQuestionId(paperId, examQuestionVo.getId(), stuId);
			if (StringUtils.isNotEmpty(paperStuDetail.getChoiceItem())) {
				String[] choiceItems = paperStuDetail.getChoiceItem().split(SEPARATOR);
				for (ExamQuestionItemVo item : examQuestionVo.getItems()) {
					for (String choiceItem : choiceItems) {
						if (item.getId().toString().equals(choiceItem)) {
							item.setIsUserChoice(CommonBoolean.Y.name());
						}
					}
				}
			}
		}
		return startExam;
	}

	@Override
	public StuStartExam paperQuestions(Long paperId) {
		StuStartExam startExam = new StuStartExam();

		QaPaper paper = new QaPaper();
		paper.setId(paperId);
		// 老师阅卷时候不打乱试题、选项顺序
		paper.setUpsetItem(CommonBoolean.N.name());
		paper.setUpsetItem(CommonBoolean.N.name());
		List<ExamQuestionVo> examQuestions = getPaperQuestions(paper);

		for (ExamQuestionVo examQuestionVo : examQuestions) {
			examQuestionVo.setCanReadNote(CommonBoolean.Y.name());
		}

		startExam.setLeftTime(0L);
		startExam.setQuestions(examQuestions);
		startExam.setPaperId(paperId);

		QaPaper dbPaper = paperMapperExt.selectByPrimaryKey(paperId);
		startExam.setPaperName(dbPaper.getPaperTitle());
		startExam.setPaperTotalScore(dbPaper.getTotalScore());

		return startExam;
	}

	@Override
	public List<PaperVo> queryCurrStuPapers() {
		Long stuId = userService.getCurrUserBySession().getId();
		List<PaperVo> paperVos = paperMapperExt.queryStuPapers(stuId);
		for (PaperVo paperVo : paperVos) {
			paperVo.setPaperPersonName(userService.queryById(paperVo.getPaperPerson()).getName());
			paperVo.setInvigilateName(userService.queryById(paperVo.getInvigilatePerson()).getName());
		}
		return paperVos;
	}

	@Override
	public QaPaper queryById(Long id) {
		return paperMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public void deletePaperById(Long paperId) {
		// 1.删除试卷
		QaPaper paper = paperMapperExt.selectByPrimaryKey(paperId);
		if (PaperStatus.UN_START.name().equals(paper.getPaperStatus())) {
			paper.setIsDeleted(CommonBoolean.Y.name());
			paperMapperExt.updateByPrimaryKeySelective(paper);
			// 2.删除学生试卷信息
			List<QaPaperStu> paperStus = paperStudentService.queryAllByPaperId(paperId);
			for (QaPaperStu paperStu : paperStus) {
				paperStu.setIsDeleted(CommonBoolean.Y.name());
			}
			BatchSupport.updateBatch(QaPaperStuMapperExt.class, MapperIdConstant.UPDATE_BY_PRIMARYKEY_SELECTIVE.getValue(), paperStus);
			// 3.删除学生选择
			List<QaPaperStuDetail> paperStuDetails = paperStudentDetailService.queryByPaperId(paperId);
			for (QaPaperStuDetail qaPaperStuDetail : paperStuDetails) {
				qaPaperStuDetail.setIsDeleted(CommonBoolean.Y.name());
			}
			BatchSupport.updateBatch(QaPaperStuDetailMapperExt.class, MapperIdConstant.UPDATE_BY_PRIMARYKEY_SELECTIVE.getValue(), paperStuDetails);
		} else {
			throw new RuntimeException("试卷已经发布，不能删除！！！");
		}
	}

	@Override
	public void publish(Long paperId, Integer examLong, String examTime, String stuIds, Long classId) {
		QaPaper dbPaper = paperMapperExt.selectByPrimaryKey(paperId);
		PaperVo paper = new PaperVo();
		paper.setDiffStage(dbPaper.getDiffStage());
		paper.setExamDate(SuperDate.parse(examTime, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS));
		paper.setExamTime(examTime);
		paper.setExamLong(examLong);
		paper.setInvigilatePerson(dbPaper.getInvigilatePerson());
		paper.setIsEffect(CommonBoolean.Y.name());
		paper.setPaperCategory(dbPaper.getPaperCategory());
		paper.setPaperPerson(userService.getCurrUserBySession().getId());
		paper.setPaperStatus(generatePaperStatus(paper).name());
		paper.setPaperTitle(dbPaper.getPaperTitle());
		paper.setQuestionAmount(dbPaper.getQuestionAmount());
		paper.setQuestionIds(dbPaper.getQuestionIds());
		paper.setTotalScore(dbPaper.getTotalScore());
		paper.setUpsetItem(dbPaper.getUpsetItem());
		paper.setUpsetQuestion(dbPaper.getUpsetQuestion());
		paperMapperExt.insertSelective(paper);
		paper.setStuIds(stuIds);
		paper.setClassId(classId);
		// 发布试卷给学生做、同时发布公告
		publishPaperToStus(paper);
	}

}
