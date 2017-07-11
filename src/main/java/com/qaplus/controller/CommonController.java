package com.qaplus.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.entity.QaAttachment;
import com.qaplus.service.AttachmentService;
import com.qaplus.utils.Festival;
import com.qaplus.utils.FestivalUtil;
import com.qaplus.utils.MobileFromUtil;
import com.qaplus.utils.PhoneInfo;

/**
 * 
 *
 */
@Controller
@RequestMapping(value = "common")
public class CommonController extends SuperController {
	@Resource
	private AttachmentService attachmentService;
	
	@RequestMapping("get_festivals")
	public List<Festival> getFestivals() {
		return FestivalUtil.getLegalFestival();
	}

	@RequestMapping("get_phone_supplier")
	public PhoneInfo getPhoneSupplier(String phone) throws UnsupportedEncodingException {
		return MobileFromUtil.calcMobileCity(phone);
	}

	// 上传附件（可以共用）
	@RequestMapping("upload_a")
	public QaAttachment uploadAttach(MultipartHttpServletRequest request) {
		QaAttachment attachment = attachmentService.uploadAttachment(request);
		return attachment;
	}
	
	// 下载附件（可以共用）
	@RequestMapping("download_a")
	public void downloadAttach(Long id, HttpServletRequest request, HttpServletResponse response) {
		attachmentService.downloadAttachs(Arrays.asList(id), request, response);
	}
}
