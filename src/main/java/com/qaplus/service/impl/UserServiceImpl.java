package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.Common;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.JobType;
import com.qaplus.constant.RoleKey;
import com.qaplus.constant.TaskContent;
import com.qaplus.entity.QaAttachment;
import com.qaplus.entity.QaClass;
import com.qaplus.entity.QaRole;
import com.qaplus.entity.QaTask;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.QaUserClass;
import com.qaplus.entity.QaUserTask;
import com.qaplus.entity.vo.ClassStuZTreeVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.UserVo;
import com.qaplus.mapper.QaUserMapperExt;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.ClassService;
import com.qaplus.service.RoleService;
import com.qaplus.service.TaskService;
import com.qaplus.service.UserClassService;
import com.qaplus.service.UserService;
import com.qaplus.service.UserTaskService;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.EncryptUtil;
import com.qaplus.utils.FileUtil;
import com.qaplus.utils.LongUtil;
import com.qaplus.utils.SuperDate;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private QaUserMapperExt userMapperExt;
	@Resource
	private TaskService taskService;
	@Resource
	private UserTaskService userTaskService;
	@Resource
	private ClassService classService;
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private RoleService roleService;
	@Resource
	private UserClassService userClassService;

	private static final String STU_TREE_PRFIX = "STU_";

	@Override
	public UserVo userLogin(String username, String password) {
		UserVo user = userMapperExt.userLogin(username);
		List<QaClass> classes = classService.queryClassByUserId(user.getId());

		String[] classNames = new String[classes.size()];
		Long[] classIds = new Long[classes.size()];
		for (int i = 0; i < classes.size(); i++) {
			QaClass clazz = classes.get(i);
			classNames[i] = clazz.getName();
			classIds[i] = clazz.getId();
		}
		user.setClassIds(classIds);
		user.setClassNames(classNames);
		return (null != user && user.getPassword().equals(password)) ? user : null;
	}

	@SystemOperatorLog(description = "用户注册")
	@Override
	public QaUser userRegister(UserVo regUser) {
		// 刚刚注册时没有用的数据，需要教师或学生确认后才有用
		regUser.setIsDeleted(CommonBoolean.Y.name());
		try {
			regUser.setPassword(EncryptUtil.encrypt(regUser.getPassword()));
		} catch (Exception e) {
			logger.error("密码加密失败", e);
		}
		regUser.setHasIcon(CommonBoolean.N.name());
		dispatchTask(regUser);
		userMapperExt.insertSelective(regUser);
		// 分配班级
		Long classIds[] = regUser.getClassIds();
		for (Long classId : classIds) {
			QaUserClass userClass = new QaUserClass();
			userClass.setClassId(classId);
			userClass.setUserId(regUser.getId());
			userClassService.add(userClass);
		}
		return regUser;
	}

	/**
	 * 提醒相关人员有用户注册了
	 * 
	 * @param regUser
	 */
	@Async
	private void dispatchTask(UserVo regUser) {
		if (regUser.getClassIds().length < 1) {
			throw new RuntimeException("请至少选择一个班级");
		}
		// 让同学或者老师审批
		QaTask task = new QaTask();
		task.setOperKey(TaskContent.USER_REGISTER.getValue());
		task.setTriggerPerson(regUser.getUsername());
		// 分配任务
		// 学生-同班同学或者老师审批
		List<QaUser> users = new ArrayList<QaUser>();
		Long[] classIds = regUser.getClassIds();
		if (regUser.getJob() == JobType.STU.getValue()) {
			if (classIds.length > 1) {
				throw new RuntimeException("学生只能在一个班级");
			}
			QaClass clazz = classService.selectByPrimary(classIds[0]);

			users = this.queryAllUserByClassId(classIds[0], CommonBoolean.N, CommonBoolean.N, null);
			// 如果班级里面学生、老师，就让所有老师审批
			if (CollectionUtils.isEmpty(users)) {
				users = this.queryAllTeachers();
			}
			task.setContent("[" + TaskContent.USER_REGISTER.getDesc() + "]  用户：" + regUser.getUsername() + "，在" + SuperDate.format(new Date(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS) + " 申请成为："
					+ clazz.getName() + "的学生");

			// 老师-所有老师审批
		} else if (regUser.getJob() == JobType.TEA.getValue()) {
			users = this.queryAllTeachers();
			task.setContent("[" + TaskContent.USER_REGISTER.getDesc() + "]  用户：" + regUser.getUsername() + "，在" + SuperDate.format(new Date(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS) + " 申请管理："
					+ getClassName(classIds) + "的学生，成为老师");
		}
		task.setKeyword(regUser.getUsername());
		taskService.addTask(task);

		for (QaUser qaUser : users) {
			QaUserTask record = new QaUserTask();
			record.setTaskId(task.getId());
			record.setUserId(qaUser.getId());
			userTaskService.addUserTask(record);
		}
	}

	private String getClassName(Long[] classIds) {
		StringBuffer classNames = new StringBuffer();
		for (Long classId : classIds) {
			QaClass clazz = classService.selectByPrimary(classId);
			classNames.append(clazz.getName()).append("、");
		}
		return classNames.toString();
	}

	@Cacheable(value = "user")
	@Override
	public List<QaUser> queryTeachersByStuId(Long stuId) {
		return userMapperExt.queryTeachersByStuId(stuId);
	}

	@Override
	public ResponseData<QaUser> queryAllUser(Page page, String searchKey) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		return new ResponseData<QaUser>(userMapperExt.queryAllUser(page, searchKey), userMapperExt.countForPage(searchKey));
	}

	@Override
	public List<QaUser> queryAllTeachers() {
		return userMapperExt.queryAllTeachers();
	}

	@Override
	public int update(QaUser record) {
		return userMapperExt.updateByPrimaryKeySelective(record);
	}

	@Override
	public QaUser queryById(Long id) {
		return userMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public List<UserVo> queryAllStusByLike(List<Long> teacherIds, String searchKey) {
		return userMapperExt.queryAllStusByLike(teacherIds, searchKey);
	}

	@Override
	public List<ClassStuZTreeVo> buildMyClassStuZTree() {
		QaUser user = this.getCurrUserBySession();
		return buildClassStuTreeForTea(user.getId());
	}

	private List<ClassStuZTreeVo> buildClassStuTreeForTea(Long teacherId) {
		List<ClassStuZTreeVo> tree = new ArrayList<ClassStuZTreeVo>();

		// 判断是否为老师
		List<QaRole> roles = roleService.queryUserRole(teacherId);
		RoleKey type = RoleKey.ROLE_STU;
		for (QaRole qaRole : roles) {
			if (RoleKey.ROLE_TEA.getValue().equals(qaRole.getRoleKey())) {
				type = RoleKey.ROLE_TEA;
				break;
			}
		}
		if (!type.equals(RoleKey.ROLE_TEA)) {
			throw new RuntimeException("你不是老师，不能构建树结构");
		}
		List<QaClass> classes = classService.queryClassByUserId(teacherId);

		for (QaClass clazz : classes) {
			ClassStuZTreeVo zTreeClass = new ClassStuZTreeVo();
			zTreeClass.setParentId("0");
			if (null != clazz) {
				zTreeClass.setName(clazz.getName());
				zTreeClass.setOpen(true);
				zTreeClass.setTreeId(clazz.getId().toString());
				tree.add(zTreeClass);

				List<QaUser> oneClassStudent = queryAllUserByClassId(clazz.getId(), CommonBoolean.Y, CommonBoolean.N, null);
				for (QaUser student : oneClassStudent) {
					ClassStuZTreeVo zTreeStudent = new ClassStuZTreeVo();
					zTreeStudent.setParentId(clazz.getId().toString());
					zTreeStudent.setName(student.getName());
					zTreeStudent.setOpen(true);
					zTreeStudent.setTreeId(STU_TREE_PRFIX + student.getId());
					tree.add(zTreeStudent);
				}
			}
		}
		return tree;
	}

	@Override
	public QaUser queryUnEffectUserByUsername(String username) {
		return userMapperExt.queryUnEffectUserByUsername(username);
	}

	@Override
	public int effectUser(Long id) {
		return userMapperExt.effectUser(id);
	}

	@Override
	public UserVo getCurrUserBySession() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		QaUser user = (QaUser) session.getAttribute(Common.CURRENT_OPERATOR.getValue());
		if (user == null) {
			return null;
		} else {
			return this.userLogin(user.getUsername(), user.getPassword());
		}
	}

	private UserVo setCurrentUserInSession(UserVo user) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(Common.CURRENT_OPERATOR.getValue());
		session.setAttribute(Common.CURRENT_OPERATOR.getValue(), user);
		return user;
	}

	@Override
	public QaUser queryByUsername(String username) {
		return userMapperExt.queryByUsername(username);
	}

	@Override
	public UserVo updateUserInfo(QaUser user) {
		if (LongUtil.isNotNull(user.getAttachmentId())) {
			user.setHasIcon(CommonBoolean.Y.name());
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			user.setPassword(null);
		} else {
			user.setPassword(EncryptUtil.encrypt(user.getPassword()));
		}
		userMapperExt.updateByPrimaryKeySelective(user);
		QaUser updatedUser = userMapperExt.selectByPrimaryKey(user.getId());
		UserVo sessionUser = this.userLogin(updatedUser.getUsername(), updatedUser.getPassword());
		this.setCurrentUserInSession(sessionUser);
		return sessionUser;
	}

	@Override
	public List<QaUser> queryUncommitHomeworkUser(Long homeworkId) {
		return userMapperExt.queryUserHomework(homeworkId, CommonBoolean.N.name());
	}

	@Override
	public List<QaUser> queryCommitHomeworkUser(Long homeworkId) {
		return userMapperExt.queryUserHomework(homeworkId, CommonBoolean.Y.name());
	}

	@Override
	public void previewImg(HttpServletResponse response) {
		QaUser user = this.getCurrUserBySession();
		if (CommonBoolean.N.name().equals(user.getHasIcon())) {
			return;
		} else if (CommonBoolean.Y.name().equals(user.getHasIcon())) {
			QaAttachment attachment = attachmentService.queryById(user.getAttachmentId());
			try {
				FileUtil.pageImgTagView(response, attachment.getAttachmentPath().substring(0, attachment.getAttachmentPath().length() - 1));
			} catch (Exception e) {
				logger.error("查看头像失败", e);
			}
		}
	}

	@Override
	public List<QaUser> queryAllUserByClassId(Long classId, CommonBoolean onlyStu, CommonBoolean onlyTeacher, String searchKey) {
		return userMapperExt.queryAllUserByClassId(classId, onlyStu.name(), onlyTeacher.name(), searchKey);
	}
}