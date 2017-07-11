package com.qaplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.UserVo;

@Repository
public interface QaUserMapperExt extends QaUserMapper {
	UserVo userLogin(@Param("username") String username);

	List<QaUser> queryTeachersByStuId(@Param("stuId") Long stuId);

	List<QaUser> queryAllTeachers();

	QaUser queryUnEffectUserByUsername(@Param("username") String username);

	int effectUser(@Param("id") Long id);

	QaUser queryByUsername(@Param("username") String username);

	List<QaUser> queryUserHomework(@Param("homeworkId") Long homeworkId, @Param("isCommit") String isCommit);

	List<QaUser> queryAllUser(@Param("page") Page page, @Param("searchKey") String searchKey);

	int countForPage(@Param("searchKey") String searchKey);

	List<UserVo> queryAllStusByLike(@Param("teacherIds") List<Long> teacherIds, @Param("searchKey") String searchKey);

	List<QaUser> queryAllUserByClassId(@Param("classId") Long classId, @Param("onlyStu") String onlyStu, @Param("onlyTeacher") String onlyTeacher, @Param("searchKey") String searchKey);

}