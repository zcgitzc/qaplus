package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qaplus.entity.QaResources;
import com.qaplus.entity.QaUser;
import com.qaplus.mapper.QaResourcesMapperExt;
import com.qaplus.service.ResourcesService;
import com.qaplus.service.UserService;

@Service
public class ResourcesServiceImpl implements ResourcesService {
	@Resource
	private QaResourcesMapperExt resourcesMapperExt;
	@Resource
	private UserService userService;

	@Cacheable(value="resources")
	@Override
	public List<QaResources> selectAll() {
		return resourcesMapperExt.selectByExample(null);
	}

	@Override
	public List<QaResources> queryMyResources() {
		QaUser user=userService.getCurrUserBySession();
		return resourcesMapperExt.selectUserResources(user.getId());
	}

	@Override
	public List<QaResources> queryHomeCenterNav() {
		QaUser user=userService.getCurrUserBySession();
		return resourcesMapperExt.selectHomeResources(user.getId());
	}

}
