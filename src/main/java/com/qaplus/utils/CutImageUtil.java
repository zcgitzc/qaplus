package com.qaplus.utils;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class CutImageUtil {

	
	/**
	 * 
	 * @param srcPath 原图片地址
	 * @param targetPath 目标地址
	 * @param x 
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void cutImage(String srcPath, String targetPath, int x,
			int y, int width, int height) {
		FileInputStream fis = null;
		ImageInputStream iis =null;
		try {
			fis = new FileInputStream(srcPath);
			int beginIndex=srcPath.lastIndexOf(".");
			
			String imgType=srcPath.substring(beginIndex+1);
			System.out.println("图片类型："+imgType);
			
			Iterator<ImageReader> it=null;
			if(imgType.equals("png")){
				// 创建图片文件流的迭代器
				 it= ImageIO
						.getImageReadersByFormatName("png");
			}else if(imgType.equals("jpg")){
				// 创建图片文件流的迭代器
				 it= ImageIO
						.getImageReadersByFormatName("jpg");
			}

			ImageReader reader = it.next();
			//获取图片流建立图片文件输入流
			iis= ImageIO.createImageInputStream(fis);
			
			reader.setInput(iis,true);
			ImageReadParam irp=reader.getDefaultReadParam();
		
			//定义图片裁剪区域
			Rectangle rect=new Rectangle(x, y, width, height);
			irp.setSourceRegion(rect);
			
			BufferedImage bi=reader.read(0, irp);
			
			//写出图片
			ImageIO.write(bi, "jpg", new File(targetPath));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//关闭流
			if(null!=fis){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(null!=iis){
						try {
							iis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cutImage("C:\\zc\\workspace\\my\\qaplus\\src\\main\\webapp\\static\\img\\test.jpg", "C:\\aa\\result.jpg", 10, 10, 80, 80);
//		cutImage("D:\\project\\qaplus\\src\\main\\webapp\\static\\img\\test.jpg", "C:\\result.jpg", 10, 10, 80, 80);
	}

}
