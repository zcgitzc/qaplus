package com.qaplus.excel.adapter;

import java.util.HashMap;
import java.util.Map;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.vo.ExamQuestionItemVo;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.utils.excel.ColumnAdapter;

public class ExportExamQuestionExcelAdapter implements ColumnAdapter {

	@Override
	public Map<String, Object> callBack(Object obj) {
		Map<String, Object> examQuestionTypeMap = new HashMap<String, Object>();
		if(obj instanceof ExamQuestionVo){
			String items="";
			for (int i = 0; i < ((ExamQuestionVo) obj).getItems().size(); i++) {
				ExamQuestionItemVo examQuestionItemVo= ((ExamQuestionVo) obj).getItems().get(i);
				if(CommonBoolean.Y.name().equals(examQuestionItemVo.getIsRightItem())){
					items+=(i+1)+":[(正确选项)"+examQuestionItemVo.getItemContent()+"]";
				}else{
					items+=(i+1)+":["+examQuestionItemVo.getItemContent()+"]";
				}
			}
			//这个items对于qa_excel_config中的column_key
			examQuestionTypeMap.put("items", items);
		}
		return examQuestionTypeMap;
	}

}
