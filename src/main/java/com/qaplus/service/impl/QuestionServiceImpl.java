package com.qaplus.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.ErrorCode;
import com.qaplus.constant.ExcelPrimaryKey;
import com.qaplus.constant.QCategory;
import com.qaplus.constant.RoleKey;
import com.qaplus.constant.TaskContent;
import com.qaplus.entity.QaRole;
import com.qaplus.entity.QaSQuestion;
import com.qaplus.entity.QaSQuestionExample;
import com.qaplus.entity.QaStuHwQuestion;
import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.QaTask;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.QaUserTask;
import com.qaplus.entity.cond.QueryQuestionCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuQuestionVo;
import com.qaplus.entity.vo.TeacherQuestionVo;
import com.qaplus.exception.BusinessException;
import com.qaplus.mapper.QaSQuestionMapperExt;
import com.qaplus.mapper.QaTQuestionMapperExt;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.QuestionService;
import com.qaplus.service.RoleService;
import com.qaplus.service.StuHwQuestionService;
import com.qaplus.service.TaskService;
import com.qaplus.service.UserService;
import com.qaplus.service.UserTaskService;
import com.qaplus.sql.batch.BatchSupport;
import com.qaplus.sql.batch.MapperIdConstant;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.LongUtil;
import com.qaplus.utils.StreamConvertUtil;
import com.qaplus.utils.SuperDate;
import com.qaplus.utils.excel.ExcelUtil;
import com.qaplus.utils.excel.sheet.ExcelSheet;
import com.qaplus.utils.mail.MailMessageInfo;
import com.qaplus.utils.mail.SendMailUtil;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger   logger= LoggerFactory.getLogger(QuestionServiceImpl.class);
	@Resource
	private QaSQuestionMapperExt sQuestionMapperExt;
	@Resource
	private QaTQuestionMapperExt tQuestionMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private TaskService taskService;
	@Resource
	private UserTaskService userTaskService;
	@Resource
	private RoleService roleService;
	@Resource
	private StuHwQuestionService stuHwQuestionService;
	@Resource
	private AttachmentService attachmentService;
	private static final String TEMPLATE_PATH="templates/stuAddQuestionTemplate.vm";

	@Override
	public ResponseData<QaSQuestion> querySQuestionForPage(Page page,QueryQuestionCond cond) {
		//如果前端有可能传begin end 也有可能传 current length
		if(page!=null && page.getEnd()==0){
			CommonBusiLogic.setPageBeginByPage(page);
		}
		QaUser user = userService.getCurrUserBySession();
		List<QaRole> roles = roleService.queryUserRole(user.getId());
		String type = RoleKey.ROLE_STU.getValue();
		for (QaRole qaRole : roles) {
			if (RoleKey.ROLE_TEA.getValue().equals(qaRole.getRoleKey())) {
				type = RoleKey.ROLE_TEA.getValue();
				break;
			}
		}
		return new ResponseData<QaSQuestion>(sQuestionMapperExt.querySQuestionForPage(page,cond, type), sQuestionMapperExt.countSQuestionForPage(cond,type));
	}

	@Override
	public ResponseData<QaTQuestion> queryTQuestionForPage(Page page,QueryQuestionCond cond) {
		if(page!=null && page.getEnd()==0){
			CommonBusiLogic.setPageBeginByPage(page);
		}
		return new ResponseData<QaTQuestion>(tQuestionMapperExt.queryTQuestionForPage(page, cond), tQuestionMapperExt.countTQuestionForPage(cond));
	}

	@Override
	public void downloadTQuestionTemplate(HttpServletResponse response) {
		try {
			//设置基本信息
			String fileName = "模板";
			fileName = fileName + SuperDate.formatAsDateString(new Date());
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
			response.setContentType("application/vnd.ms-excel");
			OutputStream outputStream = response.getOutputStream();
			//1、把Excel文件放到byteOutStream中
			ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
			ExcelUtil.exportExcel(Arrays.asList(ExcelUtil.convert2Sheet("问题列表", null,null, ExcelPrimaryKey.DOWNLOAD_T_QUESTION_TEMPLATE)),byteOutStream);
			ByteArrayInputStream byteInStream=StreamConvertUtil.parse(byteOutStream);
			//2、读取Excel设置指定的值
			Workbook workbook=ExcelUtil.openExcel(byteInStream);
			//3、设置固定值
	        Sheet sheet = workbook.getSheetAt(0);
	        String[] categroys = new String[QCategory.values().length];
	        for (int i = 0; i < QCategory.values().length; i++) {
	        	categroys[i]=QCategory.values()[i].getDesc();
			}
	        ExcelUtil.setValidation(sheet, categroys, 1, 1000, 3, 3);
	        //4、导出去
	        workbook.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
	        byteInStream.close();
	        byteOutStream.close();
		} catch (Exception e) {
			logger.error("下载模板Excel文件失败",e);
		}
	}
	
	
	@Override
	public void exportTQuestion(QueryQuestionCond cond,HttpServletResponse response) {
		try {
			List<QaTQuestion> questions=tQuestionMapperExt.queryTQuestionForPage(null, cond);
			String fileName = "教师问题Excel";
			fileName = fileName + SuperDate.formatAsDateString(new Date());
			response.setHeader("Content-disposition", "attachment;filename="
					+ fileName + ".xlsx");
			response.setContentType("application/vnd.ms-excel");
			OutputStream outputStream = response.getOutputStream();
	
			ExcelSheet sheet = ExcelUtil.convert2Sheet("问题列表", questions,null, ExcelPrimaryKey.EXPORT_T_QUESTION_TEMPLATE);
			ExcelUtil.exportExcel(Arrays.asList(sheet), outputStream);
		} catch (Exception e) {
			logger.error("导出教师试题为Excel文件失败",e);
		}
	}
	
	@Override
	public void importTQuestion(MultipartHttpServletRequest request) {
		QaTQuestion question=null;
		List<QaTQuestion> questions=new ArrayList<QaTQuestion>();
		for (Entry<String, List<MultipartFile>> entry : request.getMultiFileMap().entrySet()) {
			for (MultipartFile multipartFile : entry.getValue()) {
				try {
					Workbook workbook=ExcelUtil.openExcel(multipartFile.getInputStream());
					Sheet sheet=workbook.getSheetAt(0);
					for (int i = 0; i < sheet.getLastRowNum(); i++) {
						Row row=sheet.getRow(i+1);
						question=new QaTQuestion();
						question.setTitle(ExcelUtil.getValue(row.getCell(0)));
						question.setContent(ExcelUtil.getValue(row.getCell(1)));
						question.setAnswer(ExcelUtil.getValue(row.getCell(2)));
						question.setCategory(ExcelUtil.getValue(row.getCell(3)));
						question.setUserId(userService.getCurrUserBySession().getId());
						question.setRecCreateUser(userService.getCurrUserBySession().getUsername());
						question.setRecUpdateUser(userService.getCurrUserBySession().getUsername());
						questions.add(question);
					}
				} catch (IOException e) {
					logger.error("Excel上传试题失败",e);
				}
			}
		}
		BatchSupport.insertBatch(QaTQuestionMapperExt.class, MapperIdConstant.INSERT_SELECTIVE.getValue(), questions);
	}
	
	@SystemOperatorLog(description = "学生添加问题")
	@Override
	public void addStuQuestion(QaSQuestion question) {
		QaUser user = userService.getCurrUserBySession();
		String today = SuperDate.format(new Date(), DateFormatPatterns.DATE_PATTERN_YYYYMMDD);
		Map<Object, Object> countMap = sQuestionMapperExt.queryQuestionCountOneDay(today, user.getId());
		Long questionCount = (Long) (countMap == null ? 0L : countMap.get("value"));
		// 每天只能提三个问题
		if (questionCount >= 3) {
			throw new BusinessException(ErrorCode.QUESTION_COUNT_TOO_LARGE, ErrorCode.QUESTION_COUNT_TOO_LARGE.getDesc());
		}
		List<QaUser> teachers = userService.queryTeachersByStuId(user.getId());
		if(CollectionUtils.isEmpty(teachers)){
			throw new RuntimeException("您没有对应的老师，为你解决问题，请联系相关人员处理！！！");
		}
		question.setSolvePerson(teachers.get(0).getId());
		judgeStudentQuestionHasAttach(question);
		sQuestionMapperExt.insertSelective(question);
		
		sendEmail(question, teachers.get(0));
	}

	/**
	 * 发送邮件通知老师有学生提问
	 * @param question 问题
	 * @param teacher 老师
	 */
	@Async
	private void sendEmail(QaSQuestion question,QaUser teacher){
		QaUser user = userService.getCurrUserBySession();
		//发邮件给老师咯
		Map<String, Object> values=new HashMap<String, Object>();
		values.put("stuName", user.getName()+"("+user.getEmail()+")");
		values.put("questionTitle", question.getTitle());
		String title="";
		try {
			title=URLEncoder.encode(question.getTitle(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			title="";
		}
		//TODO 以后再实现动态
		values.put("solveQuestionUrl", "http://47.93.20.73:8080/qaplus/teacher/teaQuestionList/teaQuestionList.jsp?title="+title);
		values.put("questionContent", question.getQuestionContent());
		
		MailMessageInfo mailMessageInfo=new MailMessageInfo();
		mailMessageInfo.setTemplateName(TEMPLATE_PATH);
		mailMessageInfo.setVariables(values);
		mailMessageInfo.setReceivers(new String[]{teacher.getEmail()});
		
		Map<String, String> attachmentMaps=new HashMap<String, String>();
		//key-文件名称  value-文件路径
		if(CommonBoolean.Y.name().equals(question.getQuestionHasAttachment())){
			String zipPath=attachmentService.zipFilesByAttachId(Arrays.asList(question.getQuestionAttachmentId()));
			logger.info(String.format("学生问题附件压缩地址：%s", zipPath));
			attachmentMaps.put("学生问题附件.zip",zipPath);
			mailMessageInfo.setTitle("学生"+user.getName()+"提问（含附件）");
		}else{
			mailMessageInfo.setTitle("学生"+user.getName()+"提问");
		}
		mailMessageInfo.setAttachmentMaps(attachmentMaps);
		mailMessageInfo.setSourceId(question.getId());
		mailMessageInfo.setDescription("学生向老师提问，发邮件给老师提醒");
		try {
			SendMailUtil.sendHtmlMail(mailMessageInfo);
		} catch (Exception e) {
			logger.error(String.format("发送邮件失败，发送人：%s，收件人：%s","系统",teacher.getEmail()),e);
		}
	}
	
	@Override
	public void addTeacherQuestion(QaTQuestion question) {
		QaUser user = userService.getCurrUserBySession();
		question.setUserId(user.getId());
		judgeTeacherQuestionHasAttach(question);
		tQuestionMapperExt.insertSelective(question);
	}

	@Override
	public void updateStuQuestion(QaSQuestion question) {
		// 删除原来附件
		QaSQuestion q = sQuestionMapperExt.selectByPrimaryKey(question.getId());
		if (CommonBoolean.Y.name().equals(q.getQuestionHasAttachment())) {
			attachmentService.deleteAttachmentById(q.getQuestionAttachmentId());
		}
		judgeStudentQuestionHasAttach(question);
		sQuestionMapperExt.updateByPrimaryKeySelective(question);
	}

	@Override
	public void updateTeaQuestion(QaTQuestion question) {
		// 删除原来附件
		QaTQuestion q = tQuestionMapperExt.selectByPrimaryKey(question.getId());
		if (CommonBoolean.Y.name().equals(q.getQuestionHasAttachment())) {
			attachmentService.deleteAttachmentById(q.getQuestionAttachmentId());
		}
		if (CommonBoolean.Y.name().equals(q.getAnswerHasAttachment())) {
			attachmentService.deleteAttachmentById(q.getAnswerAttachmentId());
		}
		judgeTeacherQuestionHasAttach(question);
		QaUser user=userService.getCurrUserBySession();
		question.setRecUpdateUser(user.getUsername());
		tQuestionMapperExt.updateByPrimaryKeySelective(question);
	}

	////////////////问题图表////////////////
	@Override
	public List<Map<Object, Object>> queryForSolve() {
		return sQuestionMapperExt.queryForSolve();
	}

	@Override
	public List<Map<Object, Object>> queryForCategory() {
		return sQuestionMapperExt.queryForCategory();
	}

	@Override
	public List<Map<Object, Object>> queryForDate() {
		return sQuestionMapperExt.queryForDate();
	}
	////////////////问题图表////////////////

	@Override
	public Map<Object, Object> queryQuestionCountOneDay(String date, Long userId) {
		return sQuestionMapperExt.queryQuestionCountOneDay(date, userId);
	}

	@Override
	public List<QaSQuestion> queryUnsolveQuestion(Long id) {
		return sQuestionMapperExt.queryUnsolveQuestion(id);
	}

	/**
	 * 老师解决学生的提问
	 */
	@Override
	public void solveQuestion(QaSQuestion question) {
		QaSQuestion q = sQuestionMapperExt.selectByPrimaryKey(question.getId());
		if(q.getIsSolve().equals(CommonBoolean.Y.name())){
			throw new RuntimeException("此问题已经解决过了，系统暂不支持重复解决...");
		}
		QaUser user = userService.getCurrUserBySession();
		QaTask task = new QaTask();
		task.setContent("问题：" + q.getTitle() + " 在：" + SuperDate.format(new Date(), DateFormatPatterns.DATETIME_PATTERN_YYYYMMDDHHMMSS) + "被" + user.getName() + "老师解决");
		task.setOperKey(TaskContent.TEA_SOLVE_QUESTION.getValue());
		task.setTriggerPerson(user.getName());
		task.setKeyword(q.getTitle());
		taskService.addTask(task);

		QaUserTask record = new QaUserTask();
		record.setTaskId(task.getId());
		record.setUserId(q.getQuestionPerson());
		userTaskService.addUserTask(record);
		judgeStudentQuestionHasAttach(question);
		question.setIsSolve(CommonBoolean.Y.name());
		question.setSolveTime(new Date());

		sQuestionMapperExt.updateByPrimaryKeySelective(question);
	}
	
	/**
	 * 老师手动标记为“已解决”
	 */
	@Override
	public void markSolved(Long id){
		QaSQuestion question=new QaSQuestion();
		question.setIsSolve(CommonBoolean.Y.name());
		question.setSolveTime(new Date());
		question.setAnswerContent("老师已经和你当面解决，所以直接标记为已解决");
		sQuestionMapperExt.updateByPrimaryKeySelective(question);
	}
	
	@Override
	public int countAllMyQuestion() {
		QaUser user = userService.getCurrUserBySession();
		List<QaRole> roles = roleService.queryUserRole(user.getId());

		RoleKey type = RoleKey.ROLE_STU;

		for (QaRole qaRole : roles) {
			if (RoleKey.ROLE_TEA.getValue().equals(qaRole.getRoleKey())) {
				type = RoleKey.ROLE_TEA;
				break;
			}
		}

		QaSQuestionExample example = new QaSQuestionExample();
		if (type.equals(RoleKey.ROLE_STU)) {
			example.createCriteria().andQuestionPersonEqualTo(user.getId()).andIsSolveEqualTo(CommonBoolean.N.name());
		} else if (type.equals(RoleKey.ROLE_TEA)) {
			example.createCriteria().andSolvePersonEqualTo(user.getId()).andIsSolveEqualTo(CommonBoolean.N.name());
		}
		return sQuestionMapperExt.countByExample(example);
	}

	@Override
	public QaSQuestion queryMyAUnSovlve() {
		QaUser user = userService.getCurrUserBySession();
		if (user == null) {
			throw new BusinessException(ErrorCode.NOT_LOGIN, ErrorCode.NOT_LOGIN.getDesc());
		}
		List<QaSQuestion> questions = sQuestionMapperExt.queryUnsolveQuestion(user.getId());
		return (null == questions || questions.size() <= 0) ? null : questions.get(0);
	}

	@Override
	public TeacherQuestionVo queryTeaQuestionById(Long id) {
		QaTQuestion question = tQuestionMapperExt.selectByPrimaryKey(id);
		TeacherQuestionVo vo = new TeacherQuestionVo();
		if (StringUtils.isEmpty(question.getQuestionHasAttachment()) || CommonBoolean.N.name().equals(question.getQuestionHasAttachment())) {
			BeanUtils.copyProperties(question, vo);
			return vo;
		}
		return tQuestionMapperExt.queryTeaQuestionById(id);
	}

	@Override
	public TeacherQuestionVo queryTeaAnswerById(Long id) {
		QaTQuestion question = tQuestionMapperExt.selectByPrimaryKey(id);
		TeacherQuestionVo vo = new TeacherQuestionVo();
		if (StringUtils.isEmpty(question.getQuestionHasAttachment()) || CommonBoolean.N.name().equals(question.getQuestionHasAttachment())) {
			BeanUtils.copyProperties(question, vo);
			return vo;
		}
		return tQuestionMapperExt.queryTeaAnswerById(id);
	}

	@Override
	public List<QaTQuestion> queryTeaQuestionByIds(Long[] ids) {
		List<QaTQuestion> questions = new ArrayList<QaTQuestion>();
		for (Long id : ids) {
			if (null != id) {
				QaTQuestion q = tQuestionMapperExt.selectByPrimaryKey(id);
				if (null != q) {
					questions.add(q);
				}
			}
		}
		return questions;
	}

	@Override
	public void deleteTeaQuestion(QaTQuestion question) {
		question.setIsDeleted(CommonBoolean.Y.name());
		tQuestionMapperExt.updateByPrimaryKeySelective(question);
	}

	@Override
	public void deleteStuQuestion(QaSQuestion question) {
		question.setIsDeleted(CommonBoolean.Y.name());
		sQuestionMapperExt.updateByPrimaryKeySelective(question);
	}

	@Override
	public List<QaTQuestion> queryMyHomeworkQuestion(Long homeworkId) {
		QaUser user = userService.getCurrUserBySession();
		return tQuestionMapperExt.queryMyHomeworkQuestion(homeworkId, user.getId());
	}

	@Override
	public List<QaTQuestion> queryHomeworkQuestions(Long homeworkId) {
		List<QaTQuestion> questions = new ArrayList<QaTQuestion>();
		List<QaStuHwQuestion> stuHwQuestions = stuHwQuestionService.queryByHomeworkId(homeworkId);
		for (QaStuHwQuestion qaStuHwQuestion : stuHwQuestions) {
			QaTQuestion question = tQuestionMapperExt.selectByPrimaryKey(Long.parseLong(qaStuHwQuestion.getQuestionId().toString()));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public StuQuestionVo queryStuQuestionById(Long id) {
		QaSQuestion question = sQuestionMapperExt.selectByPrimaryKey(id);
		StuQuestionVo vo = new StuQuestionVo();
		if (StringUtils.isEmpty(question.getQuestionHasAttachment()) || CommonBoolean.N.name().equals(question.getQuestionHasAttachment())) {
			BeanUtils.copyProperties(question, vo);
			return vo;
		}
		return sQuestionMapperExt.queryStuQuestionAndAttachById(id);
	}

	/**
	 * 判断学生问题   问题是否有附件，以及老师回答是否有附件
	 * @param question
	 */
	private void judgeStudentQuestionHasAttach(QaSQuestion question){
		if (LongUtil.isNotNull(question.getQuestionAttachmentId())) {
			question.setQuestionHasAttachment(CommonBoolean.Y.name());
		}
		if(LongUtil.isNotNull(question.getAnswerAttachmentId())){
			question.setAnswerHasAttachment(CommonBoolean.Y.name());
		}
	}
	/**
	 * 判断老师问题  问题是否有附件，以及问题答案是否有附件
	 * @param question
	 */
	private void judgeTeacherQuestionHasAttach(QaTQuestion question){
		if (LongUtil.isNotNull(question.getQuestionAttachmentId())) {
			question.setQuestionHasAttachment(CommonBoolean.Y.name());
		}
		if (LongUtil.isNotNull(question.getAnswerAttachmentId())) {
			question.setAnswerHasAttachment(CommonBoolean.Y.name());
		}
	}

}
