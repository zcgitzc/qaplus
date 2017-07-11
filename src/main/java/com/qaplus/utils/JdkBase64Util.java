/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.qaplus.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 类JdkBase64Util.java的实现描述：TODO 类实现描述
 * 
 * @author moxian.zl 2014-2-19 上午10:31:55
 */
public class JdkBase64Util {

    public static byte[] decode(String str) throws IOException {
        if (str == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(str);
    }

    public static String decodeAsStr(String str) throws IOException {
        return new String(decode(str));
    }

    public static String decodeAsStr(String str, String encode) throws IOException {
        return new String(decode(str), encode);
    }

    public static String encode(byte[] content) {
        if (content == null) {
            return null;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(content);
    }

    public static String encode(String content) {
        return encode(content.getBytes());
    }

    public static String encode(String content, String encode) throws IOException {
        return encode(content.getBytes(encode));
    }
}
