package com.qaplus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.entity.QaAttachment;

public interface AttachmentService {
	//添加附件
	void insertSelective(QaAttachment attachment);
	//上传附件
	QaAttachment uploadAttachment(MultipartHttpServletRequest request);
	//下载附件
	void downloadAttachs(List<Long> ids,HttpServletRequest request, HttpServletResponse response);
	//删除附件
	void deleteAttachmentById(Long id);
	
	QaAttachment queryById(Long id);
	
	String zipFilesByAttachId(List<Long> ids);
}		
