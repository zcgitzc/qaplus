package com.qaplus.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RemoteLoginTest  
{  
    public static void main(String[] args) throws Exception//以下仅举个小例子，不处理异常  
    {  
        String loginUrl="http://syjy.5u5u5u5u.com/syjy/login.htm?name=362324199705140911&password=123456&validateCode=7ae5";  
        URL url = new URL(loginUrl);  
        URLConnection conn = url.openConnection();  
  
        String sessionValue = conn.getHeaderField("Set-Cookie");//获取session值  
          
        String[] sessionId = sessionValue.split(";");  
        URL newUrl = new URL("http://syjy.5u5u5u5u.com/syjy/reserve/queryExperienceLessonReserveData.htm");  
        URLConnection newConn = newUrl.openConnection();  
        newConn.setRequestProperty("Cookie", sessionId[0]);  
        newConn.connect();  
          
        BufferedInputStream bis = new BufferedInputStream(newConn.getInputStream());  
        InputStreamReader inputStreamReader = new InputStreamReader(bis,"utf-8");   
        BufferedReader br = new BufferedReader(inputStreamReader);  
  
        String str = null;  
        while ((str = br.readLine()) != null)   
        {  
            System.out.println(str);//输出登录后才能访问的网页的html源码，可以根据需要获取相关信息  
        }  
    }  
} 