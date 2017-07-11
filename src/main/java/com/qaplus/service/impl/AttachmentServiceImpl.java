package com.qaplus.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.constant.AttachmentDesc;
import com.qaplus.constant.Common;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaAttachment;
import com.qaplus.entity.QaUser;
import com.qaplus.mapper.QaAttachmentMapperExt;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.QuestionService;
import com.qaplus.service.UserService;
import com.qaplus.utils.DateFormatPatterns;
import com.qaplus.utils.FileUtil;
import com.qaplus.utils.SuperDate;

@Service
public class AttachmentServiceImpl implements AttachmentService {
	private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);
	@Resource
	private QaAttachmentMapperExt attachmentMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private QuestionService questionService;

	//有多个附件，附件路劲用#分割
	private static final String DELIMETER = "#";
	//下载的文件名
	private static final String DOWNLOAD_FILE_NAME = "附件_";
	//文件名的分割符号
	private static final String DOWNLOAD_FILE_NAME_SEPARATOR = "_";
	private static final String ZIP_NAME=DOWNLOAD_FILE_NAME + DOWNLOAD_FILE_NAME_SEPARATOR + SuperDate.format(new Date(), DateFormatPatterns.DATETIME_PATTERN_DEFAULT) + Common.ZIP_FILE_SUFFIX.getValue();

	@Override
	public void insertSelective(QaAttachment attachment) {
		attachmentMapperExt.insertSelective(attachment);
	}

	@Override
	public QaAttachment uploadAttachment(MultipartHttpServletRequest request) {
		QaUser user = userService.getCurrUserBySession();
		QaAttachment attachment = new QaAttachment();
		String attachmentFileRealName = "";
		String attachmentFileName = "";
		String attachmentPath = "";
		for (Entry<String, List<MultipartFile>> entry : request.getMultiFileMap().entrySet()) {
			for (MultipartFile multipartFile : entry.getValue()) {
				if (multipartFile != null) {
					// 取得当前上传文件的文件名称
					String realName = multipartFile.getOriginalFilename();
					if (!StringUtils.isEmpty(realName)) {
						attachmentFileRealName += realName + DELIMETER;
						String prefix = Common.FILE_PATH.getValue();
						File prefixFile = new File(prefix);
						if (!prefixFile.exists()) {
							prefixFile.mkdir();
						}
						String fileName =user.getUsername()+DOWNLOAD_FILE_NAME_SEPARATOR+SuperDate.format(new Date(), DateFormatPatterns.DATETIME_PATTERN_DEFAULT) +DOWNLOAD_FILE_NAME_SEPARATOR+ realName;
						attachmentFileName += fileName + DELIMETER;
						String outputPath = prefix + fileName;
						attachmentPath += outputPath + DELIMETER;
						File localFile = new File(outputPath);
						try {
							multipartFile.transferTo(localFile);
						} catch (IllegalStateException | IOException e) {
							logger.error("上传文件失败", e);
						}
					}
					logger.info(String.format("文件上传成功，路径:%s", attachmentPath));
				}
			}
		}
		attachment.setAttachmentDesc(AttachmentDesc.STU_QUESTION_ATTACH.getValue());
		attachment.setAttachmentName(attachmentFileName);
		attachment.setAttachmentPath(attachmentPath);
		attachment.setAttachmentRealName(attachmentFileRealName);
		attachmentMapperExt.insertSelective(attachment);
		return attachment;
	}

	@Override
	public void downloadAttachs(List<Long> ids, HttpServletRequest request, HttpServletResponse response) {
		try {
			this.zipFilesByAttachId(ids);
			FileUtil.localDownload(request, response, Common.ZIP_FILE_SUFFIX.getValue(), ZIP_NAME, Common.TEMP_ZIP_PATH.getValue() + ZIP_NAME);
		} catch (Exception e) {
			logger.error("下载文件失败", e);
		}
	}

	@Override
	public String zipFilesByAttachId(List<Long> ids) {
		List<File> files = new ArrayList<File>();
		for (Long id : ids) {
			QaAttachment attachment = attachmentMapperExt.selectByPrimaryKey(id);
			if (attachment != null) {
				String[] attachNames = attachment.getAttachmentName().split(DELIMETER);
				for (int i = 0; i < attachNames.length; i++) {
					String filePath=attachment.getAttachmentPath().split(DELIMETER)[i];
					File file = new File(filePath);
					//转为附件的真实名称
					String fileRealName=attachment.getAttachmentRealName();
					String[] fileRealNames=fileRealName.split(DELIMETER);
					if(fileRealNames[i].endsWith(DELIMETER)){
						fileRealNames[i]=fileRealNames[i].substring(0,fileRealNames[i].length()-1);
					}
					File targetFile=new File(Common.TEMP_FILE_PATH.getValue()+fileRealNames[i]);
					try {
						FileUtils.copyFile(file,targetFile);
					} catch (IOException e) {
						logger.error("复制文件失败", e);
					}
					files.add(targetFile);
				}
			}
		}
		// 附件_1_1_20160514.zip
		FileUtil.createNewDir(Common.TEMP_ZIP_PATH.getValue());
		try {
			FileUtil.zipFile(files, new ZipOutputStream(new FileOutputStream(Common.TEMP_ZIP_PATH.getValue() + ZIP_NAME)));
		} catch (Exception e) {
			logger.error("压缩文件失败...", e);
		}
		return Common.TEMP_ZIP_PATH.getValue() + ZIP_NAME;
	}

	

	@Override
	public void deleteAttachmentById(Long id) {
		QaAttachment attachment = attachmentMapperExt.selectByPrimaryKey(id);
		// 将原来文件删除
		String[] delPaths = attachment.getAttachmentPath().split("#");
		for (String delPath : delPaths) {
			try {
				FileUtil.deleteFile(delPath);
			} catch (IOException e) {
				logger.error(String.format("用户修改文件时，要求删除原文件失败,附件Id:%s", id.toString()), e);
			}
		}
		attachment.setIsDeleted(CommonBoolean.Y.name());
		attachmentMapperExt.updateByPrimaryKeySelective(attachment);
	}

	@Override
	public QaAttachment queryById(Long id) {
		return attachmentMapperExt.selectByPrimaryKey(id);
	}

}
