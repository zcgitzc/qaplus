package com.qaplus.common;

import com.qaplus.entity.vo.Page;

/**
 * 
 */
public class CommonBusiLogic {
	/**
	 * 初始化Page的Begin和End
	 * 
	 * @param page
	 * @return
	 */
	public static Page setPageBeginByPage(Page page) {
		if (page != null) {
			page.setBegin(((page.getCurrent() - 1) * page.getLength()));
			page.setEnd(page.getBegin() + page.getLength());
		}
		return page;
	}
	
	
	
	

}
