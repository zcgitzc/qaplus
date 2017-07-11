package com.qaplus.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.ClassStuZTreeVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.UserVo;

public interface UserService {
	/**
	 * 查看用户头像
	 * @param response
	 */
	void previewImg(HttpServletResponse response);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户
	 */
	UserVo userLogin(String username, String password);

	/**
	 * 找到学生的所有老师
	 * @param stuId 学生ID
	 * @return
	 */
	List<QaUser> queryTeachersByStuId(Long stuId);

	/**
	 * 用户注册
	 * @param user 用户
	 * @return
	 */
	QaUser userRegister(UserVo user);

	/**
	 * 查询所用用户
	 * @param page 分页
	 * @param searchKey 模糊搜索（名称、用户名）
 	 * @return 用户
	 */
	ResponseData<QaUser> queryAllUser(Page page,String searchKey);

	/**
	 * 查看所有老师
	 * @return
	 */
	List<QaUser> queryAllTeachers();

	/**
	 * 修改用户
	 * @param record
	 * @return
	 */
	int update(QaUser record);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	QaUser queryById(Long id);
	
	/**
	 * 根据用户名查询刚刚注册的用户（未生效）
	 * @param username 用户名
	 * @return
	 */
	QaUser queryUnEffectUserByUsername(String username);
	
	/**
	 * 生效用户
	 * @param id
	 * @return
	 */
	int effectUser(Long id);
	
	/**
	 * 查询老师的所有学生
	 * @param teacherIds 老师IDs
	 * @param searchKey 搜索key 
	 * @return 学生列表
	 */
	List<UserVo> queryAllStusByLike(List<Long> teacherIds,String searchKey);
	
	/**
	 * 查询某班级下的用户
	 * @param classId 班级ID 
	 * @param onlyStu 只查看学生 
	 * @param onlyTeacher 只查看老师
	 * @param searchKey 搜索key
	 * @return 用户列表
	 */
	List<QaUser> queryAllUserByClassId(Long classId,CommonBoolean onlyStu,CommonBoolean onlyTeacher,String searchKey);
	
	/**
	 * 老师带的所有班级学生  树形结构展示
	 * @return
	 */
	List<ClassStuZTreeVo> buildMyClassStuZTree();
	
	/**
	 * 从Session中获取用户 
	 * @return 用户
	 */ 
	UserVo getCurrUserBySession();
	
	/**
	 * 根据用户名查看用户
	 * @param username
	 * @return
	 */
	QaUser queryByUsername(String username);
	
	/**
	 * 修改用户信息
	 * @param user 用户 
	 * @return 修改后的信息
	 */
	UserVo updateUserInfo(QaUser user);

	/**
	 * 没有交家庭作业都人 
	 * @param homeworkId 家庭作业ID
	 * @return 用户列表
	 */
	List<QaUser> queryUncommitHomeworkUser(Long homeworkId);
	
	/**
	 * 查看已经提交家庭作业的人
	 * @param homeworkId 家庭作业ID
	 * @return 用户列表
	 */
	List<QaUser> queryCommitHomeworkUser(Long homeworkId);
	
}
