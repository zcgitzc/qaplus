package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.common.CommonBusiLogic;
import com.qaplus.entity.QaSystemConstant;
import com.qaplus.entity.QaSystemConstantExample;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.mapper.QaSystemConstantMapperExt;
import com.qaplus.service.SystemConstantService;

@Service
public class SystemConstantServiceImpl implements SystemConstantService {
	@Resource
	private QaSystemConstantMapperExt systemConstantMapperExt;

	@Override
	public List<QaSystemConstant> queryByCategorys(List<String> categorys) {
		QaSystemConstantExample example = new QaSystemConstantExample();
		example.createCriteria().andCategoryIn(categorys);
		example.setOrderByClause("serial asc");
		return systemConstantMapperExt.selectByExample(example);
	}
	
	@Override
	public void updateById(QaSystemConstant constant) {
		systemConstantMapperExt.updateByPrimaryKeySelective(constant);
	}
	
	@Override
	public ResponseData<QaSystemConstant> queryForPage(Page page,String searchKey){
		//如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		List<QaSystemConstant> constants=systemConstantMapperExt.queryForPage(page,searchKey);
		int count=systemConstantMapperExt.countForPage(searchKey);
		return new ResponseData<QaSystemConstant>(constants, count);
	}

}
