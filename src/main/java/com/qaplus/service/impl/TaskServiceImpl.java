package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qaplus.constant.AuditMsgDefault;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.TaskContent;
import com.qaplus.entity.QaTask;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.QaUserRole;
import com.qaplus.mapper.QaTaskMapperExt;
import com.qaplus.service.TaskService;
import com.qaplus.service.UserRoleService;
import com.qaplus.service.UserService;
import com.qaplus.service.UserTaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Resource
	private QaTaskMapperExt taskMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private UserTaskService userTaskService;

	@Override
	public int addTask(QaTask task) {
		return taskMapperExt.insertSelective(task);
	}

	@Override
	public List<QaTask> queryMyTask() {
		QaUser user = userService.getCurrUserBySession();
		return taskMapperExt.queryTaskByUserId(user.getId());
	}

	@Override
	public int agree(QaTask qaTask) {
		QaTask task = taskMapperExt.selectByPrimaryKey(qaTask.getId());

		task.setIsSolve(CommonBoolean.Y.name());
		task.setAuditMsg(StringUtils.isEmpty(qaTask.getAuditMsg()) ? AuditMsgDefault.AGREE.getValue() : qaTask.getAuditMsg());
		task.setIsAgree(CommonBoolean.Y.name());
		task.setIsDeleted(CommonBoolean.Y.name());
		if (TaskContent.USER_REGISTER.equals(TaskContent.valueOf(task.getOperKey()))) {
			QaUser user = userService.queryUnEffectUserByUsername(task.getTriggerPerson());
			if (user != null) {
				userService.effectUser(user.getId());
				// 分配角色
				QaUserRole userRole = new QaUserRole();
				userRole.setUserId(user.getId());
				userRole.setRoleId(Long.valueOf(user.getJob()));
				userRoleService.addUserRole(userRole);
			} else {
				throw new RuntimeException("注册用户已经不存在");
			}
		}
		// 删除userTask表的关系
		userTaskService.delUserTask(qaTask.getId());
		return taskMapperExt.updateByPrimaryKeySelective(task);
	}

	@Override
	public int reject(QaTask qaTask) {
		QaTask task = taskMapperExt.selectByPrimaryKey(qaTask.getId());

		task.setIsSolve(CommonBoolean.Y.name());
		task.setAuditMsg(StringUtils.isEmpty(qaTask.getAuditMsg()) ? AuditMsgDefault.REJECT.getValue() : qaTask.getAuditMsg());
		task.setIsAgree(CommonBoolean.N.name());

		return taskMapperExt.updateByPrimaryKeySelective(task);
	}

}
