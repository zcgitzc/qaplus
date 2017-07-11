package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaResources;

public interface ResourcesService {
	List<QaResources> selectAll();

	List<QaResources> queryMyResources();

	List<QaResources> queryHomeCenterNav();

}
