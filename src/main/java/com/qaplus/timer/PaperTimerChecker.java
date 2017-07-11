package com.qaplus.timer;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.DiffStage;
import com.qaplus.constant.ExamStatus;
import com.qaplus.constant.PaperStatus;
import com.qaplus.entity.QaPaper;
import com.qaplus.entity.QaPaperStu;
import com.qaplus.entity.QaScore;
import com.qaplus.entity.QaUser;
import com.qaplus.service.BoardService;
import com.qaplus.service.PaperService;
import com.qaplus.service.PaperStudentService;
import com.qaplus.service.ScoreService;
import com.qaplus.service.UserService;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.SuperDate;

/**
 * 检查试卷（is_effect为N 的说明学生已经考完了）
 * 
 * @author zc
 *
 */
@Component
public class PaperTimerChecker {
	@Resource
	private PaperService paperService;
	@Resource
	private ScoreService scoreService;
	@Resource
	private PaperStudentService paperServiceStudent;
	@Resource
	private BoardService boardService;
	@Resource
	private UserService userService;

	@Scheduled(cron = "0/2 * *  * * ? ")
	// 每2秒执行一次
	public void start() {
		List<QaPaper> papers = paperService.queryAllEffectPaper();
		for (QaPaper paper : papers) {
			PaperStatus status = paperService.generatePaperStatus(paper);
			if (PaperStatus.STARTED.equals(status)) {
				paper.setIsEffect(CommonBoolean.N.name());
				forceSubmitPaper(paper.getId());
				// 发布公告：统计学生分数，表扬前三名、计算平均分
				addBoard(paper);
				// 根据考试考出来的品均分调整试题的难度
				updatePaperDiffStage(paper);
			}
			if (!status.name().equals(paper.getPaperStatus())) {
				paper.setPaperStatus(status.name());
				paperService.update(paper);
			}
		}
	}

	/**
	 * 根据考试考出来的品均分调整试题的难度
	 * 
	 * @param paper
	 */
	private void updatePaperDiffStage(QaPaper paper) {
		int paperAvg = paperService.getPaperAvg(paper.getId());
		if (paperAvg < paper.getTotalScore() * (40 / 100)) {
			paper.setDiffStage(DiffStage.DIFFICULT.name());
		} else if (paperAvg >= paper.getTotalScore() * (40 / 100) && paperAvg < paper.getTotalScore() * (70 / 100)) {
			paper.setDiffStage(DiffStage.MIDDLE.name());
		} else if (paperAvg >= paper.getTotalScore() * (70 / 100)) {
			paper.setDiffStage(DiffStage.EASY.name());
		}
	}

	/**
	 * 系统强制交卷、没有参加考试的分数自动0分
	 * 
	 * @param paperId
	 */
	private void forceSubmitPaper(Long paperId) {
		// 试卷考试时间已到，直接修改学生（is_submit="N" 的学生）成绩为0
		List<QaPaperStu> paperStus = paperServiceStudent.queryAllUnSumit(paperId);
		for (QaPaperStu qaPaperStu : paperStus) {
			QaScore score = new QaScore();
			score.setStuId(qaPaperStu.getStuId());
			score.setPaperId(paperId);
			score.setScore(0);
			scoreService.add(score);
			qaPaperStu.setExamStatus(ExamStatus.EXAMED.name());
			qaPaperStu.setIsSubmit(CommonBoolean.Y.name());
			paperServiceStudent.update(qaPaperStu);
		}
	}

	/**
	 * 发布公告：表扬前三名、计算平均分
	 * 
	 * @param paper
	 */
	private void addBoard(QaPaper paper) {
		String stus = getAllExamStus(paper.getId());
		List<QaScore> stuScores = scoreService.queryTopThree(paper.getId());
		Date startDate = SuperDate.now();
		Date endDate = SuperDate.addDays(startDate, 3);
		String now = SuperDate.format(startDate, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS);
		String end = SuperDate.format(endDate, DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS);

		String boardContent = "热烈祝贺：";
		for (QaScore qaScore : stuScores) {
			if (qaScore.getScore() != 0) {
				QaUser user = userService.queryById(qaScore.getStuId());
				boardContent += user.getName() + "(" + qaScore.getScore() + "分)" + "、";
			}
		}
		int avgScore = paperService.getPaperAvg(paper.getId());
		boardContent += "  在【" + paper.getPaperTitle() + "】考试中，获得前三名的成绩，试卷总分：" + paper.getTotalScore() + "，此次考试平均分：" + avgScore;

		boardService.addBoard(boardContent, CommonBoolean.Y.name(), CommonBoolean.Y.name(), end, now, stus);
	}

	/**
	 * 获取参加考试的人
	 * 
	 * @param paperId
	 * @return
	 */
	private String getAllExamStus(Long paperId) {
		String stus = "";
		List<QaPaperStu> paperStu = paperServiceStudent.queryAllByPaperId(paperId);
		for (QaPaperStu qaPaperStu : paperStu) {
			stus += qaPaperStu.getStuId() + ",";
		}
		return stus;
	}

}
