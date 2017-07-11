package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaSystemConstant;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;

public interface SystemConstantService {
	List<QaSystemConstant> queryByCategorys(List<String> categorys);

	void updateById(QaSystemConstant constant);

	ResponseData<QaSystemConstant> queryForPage(Page page, String searchKey);

}
