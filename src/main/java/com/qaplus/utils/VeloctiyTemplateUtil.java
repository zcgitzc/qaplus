/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.qaplus.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeloctiyTemplateUtil {

    private static Logger         log                 = LoggerFactory.getLogger(VeloctiyTemplateUtil.class);

    private static final String   VELOCITY_PROPERTIES = "/velocity.properties";
    public static final String    DEFAULT_FILE_ENCODE = "UTF-8";
    private static VelocityEngine ve;

    static {
        log.info("Begin to init veloctiy engine");
        ve = new VelocityEngine();
        //pdf导出，发送邮件可以用velocity
        Properties p = new Properties();
        // 加载classpath目录下的vm文件
        // 这里是加载模板VM文件，比如：/META-INF/template/Web_B2CPayment.vm（请参考mas_spring_integration.xml）
        p.setProperty("file.resource.loader.class",
              "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        // 初始化Velocity引擎，init对引擎VelocityEngine配置了一组默认的参数 
        
        
        //读取资源文件的方式 
        /*InputStream in = null;
        try {
            in = VeloctiyTemplateUtil.class.getResourceAsStream(VELOCITY_PROPERTIES);
            if (in == null) {
                throw new IOException();
            }
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("Close velocityProperties inputStream ", e);
                }
            }
        }*/
        ve.init(p);
        log.info("Init veloctiy engine success");
    }

    public static String getContent(String fileName, Map<String, Object> values) {
        Template template = ve.getTemplate(fileName, DEFAULT_FILE_ENCODE);
        if (values == null) {
            values = new HashMap<String, Object>();
        }
        VelocityContext context = getContext(values);
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        return sw.toString();
    }

    private static VelocityContext getContext(Map<String, Object> values) {
        VelocityContext context = new VelocityContext();

        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                context.put(key, value);
            }
        }
        return context;
    }
}
