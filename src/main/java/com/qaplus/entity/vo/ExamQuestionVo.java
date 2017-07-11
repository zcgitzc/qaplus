package com.qaplus.entity.vo;

import java.util.List;

import com.qaplus.entity.QaExamQuestion;

public class ExamQuestionVo extends QaExamQuestion {
	private List<ExamQuestionItemVo> items;
	private String[] itemContent;
	private String[] isRightItem;
	private Long choiceItem;
	private String canReadNote;
	private int errorCount;

	public List<ExamQuestionItemVo> getItems() {
		return items;
	}

	public void setItems(List<ExamQuestionItemVo> items) {
		this.items = items;
	}

	public String[] getItemContent() {
		return itemContent;
	}

	public void setItemContent(String[] itemContent) {
		this.itemContent = itemContent;
	}

	public String[] getIsRightItem() {
		return isRightItem;
	}

	public void setIsRightItem(String[] isRightItem) {
		this.isRightItem = isRightItem;
	}

	public Long getChoiceItem() {
		return choiceItem;
	}

	public void setChoiceItem(Long choiceItem) {
		this.choiceItem = choiceItem;
	}

	public String getCanReadNote() {
		return canReadNote;
	}

	public void setCanReadNote(String canReadNote) {
		this.canReadNote = canReadNote;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

}
