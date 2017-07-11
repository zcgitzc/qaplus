package com.qaplus.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

public class LogbackListener implements ServletContextListener{
	private static final Logger logger = LoggerFactory.getLogger(LogbackListener.class);

	//TODO 以後在修改
	private static final String TMP_LOG_PATH="C:"+File.separator+"logs";
	private static final String TMP_PROJECT_NAME="qaplus";
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
        try {
			ServletContext sc = event.getServletContext();
//			String realPath=sc.getRealPath("").substring(0,sc.getRealPath("").indexOf("\\", sc.getRealPath("").indexOf("\\")+1));
//			String projectName=sc.getContextPath().substring(1, sc.getContextPath().length());
//			
//			//TODO 这个路径有问题
//			String logPath=realPath+ SystemUtils.FILE_SEPARATOR + projectName+SystemUtils.FILE_SEPARATOR +"logs";
			logger.info(String.format("日志路径：%s", TMP_LOG_PATH));
			//添加系统属性示例代码
			if (org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS) {
			   System.setProperty("log.path", TMP_LOG_PATH);
			} else {//linux
			   System.setProperty("log.path", "/logs");
			}
			System.setProperty("log.project.name", TMP_PROJECT_NAME);
			boolean isProductEnv=false;//非生产环境、
			
			if (isProductEnv) {
			   System.setProperty("log.root.level", "INFO");
			} else {//非生产环境
			   System.setProperty("log.root.level", "INFO");
			} 
			WebLogbackConfigurer.initLogging(sc);
		} catch (Exception e) {
			logger.error("初始化logback日志失败", e);
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent event){
        WebLogbackConfigurer.shutdownLogging(event.getServletContext());
    }
}
