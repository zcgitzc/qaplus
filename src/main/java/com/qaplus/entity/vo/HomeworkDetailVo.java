package com.qaplus.entity.vo;

import java.util.List;

import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.QaUser;

public class HomeworkDetailVo {
	private Long homeworkId;
	private List<QaTQuestion> questions;
	private List<QaUser> unCommitUsers;
	private List<QaUser> commitUsers;

	public Long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}

	public List<QaTQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QaTQuestion> questions) {
		this.questions = questions;
	}

	public List<QaUser> getUnCommitUsers() {
		return unCommitUsers;
	}

	public void setUnCommitUsers(List<QaUser> unCommitUsers) {
		this.unCommitUsers = unCommitUsers;
	}

	public List<QaUser> getCommitUsers() {
		return commitUsers;
	}

	public void setCommitUsers(List<QaUser> commitUsers) {
		this.commitUsers = commitUsers;
	}

}
