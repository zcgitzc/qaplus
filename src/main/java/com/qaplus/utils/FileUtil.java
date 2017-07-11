package com.qaplus.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件读写工具
 * <dl>
 * <dt>作用:</dt>
 * <dd>1.读取文件保存在字符串中</dd>
 * <dd>2.写出文件</dd>
 * <dd>3.一行一行的读取文件保存在List&lt;String&gt;中</dd>
 * </dl>
 * 
 */
public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final int MAX_BUFFER_SIZE = 1024;

	/**
	 * 使用UTF-8编码格式读取文件到字符串
	 * 
	 * @param path
	 *            文件路径
	 * @return 文件内容字
	 * @throws Exception
	 */
	public static String readFile(String path) throws Exception {

		return readFile(path, DEFAULT_ENCODING);
	}

	/**
	 * 读取文件到字符串
	 * 
	 * @param path
	 *            文件路径
	 * @param encoding
	 *            编码格式
	 * @return 文件内容字符
	 * @throws Exception
	 */
	public static String readFile(String path, String encoding) throws Exception {

		File file = new File(path);
		FileInputStream fis = null;
		InputStreamReader reader = null;
		StringBuffer output = new StringBuffer();

		try {
			fis = new FileInputStream(file);
			reader = new InputStreamReader(fis, encoding);
			char[] buffer = new char[MAX_BUFFER_SIZE];
			int n = MAX_BUFFER_SIZE;
			while ((n = reader.read(buffer, 0, MAX_BUFFER_SIZE)) != -1) {
				output.append(buffer, 0, n);
			}

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return output.toString();
	}

	/**
	 * 使用UTF-8编码格式将字符串写入文件
	 * 
	 * @param content
	 *            写入内容字符
	 * @param path
	 *            文件路径
	 * @return 成功 true 失败false
	 */
	public static boolean writeFile(String content, String path) {

		return writeFileForString(content, path, DEFAULT_ENCODING);
	}

	/**
	 * 将字符串写入文件
	 * 
	 * @param content
	 *            写入内容字符
	 * @param path
	 *            文件路径
	 * @param encoding
	 *            编码格式
	 * @return 成功 true 失败false
	 */
	public static boolean writeFileForString(String content, String path, String encoding) {

		File file = new File(path);
		File parentFile = new File(file.getParent());
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;

		try {
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}

			fos = new FileOutputStream(file);
			writer = new OutputStreamWriter(fos, encoding);
			writer.write(content);

		} catch (IOException e) {
			logger.error("写入文件失败", e);
			return false;
		} finally {

			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 获取类在文件系统的路径
	 * 
	 * @param clazz
	 *            目标
	 * @return 路径
	 */
	public static String getClassFolderPath(Class<?> clazz) {

		ClassLoader loader = clazz.getClassLoader();
		String packagePath = clazz.getPackage().getName().replace('.', '/');
		String url = loader.getResource(packagePath).getPath();
		try {
			url = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return url;
	}

	/**
	 * 读取文件内容，以行为单位生成字符串列（一行一行读取文件，每一行存储在List<String> 中）
	 * 
	 * @param path
	 *            文件路径
	 * @return 字符串列
	 * @throws Exception
	 */
	public static List<String> readFileToLines(String path) throws Exception {

		File file = new File(path);
		FileReader fr = null;
		BufferedReader reader = null;
		List<String> content = new ArrayList<String>();

		try {
			fr = new FileReader(file);

			reader = new BufferedReader(fr);
			String buffer = null;
			while ((buffer = reader.readLine()) != null) {
				content.add(buffer.trim());
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return content;
	}

	/**
	 * 远程下载文件
	 * 
	 * @param urlString
	 *            网址
	 * @param filename
	 *            下载之后的文件名字
	 * @param savePath
	 *            文件保存的路劲
	 * @return 是否保存成功
	 * @throws Exception
	 */
	public static boolean remoteDownload(String urlString, String filename, String savePath) throws Exception {
		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			File sf = new File(savePath);
			if (!sf.exists()) {
				sf.mkdirs();
			}
			OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			return true;
		} catch (Exception e) {
			logger.error(String.format("向别的网站下载文件失败 地址：%s", urlString), e);
			return false;
		}

	}

	/**
	 * 客户向本地服务器下载文件
	 * 
	 * @param request
	 * @param response
	 * @param storeName
	 *            文件名称
	 * @param contentType
	 *            文件类型
	 * @param realName
	 *            文件真实名称
	 * @param downloadpath
	 *            文件路径
	 * @throws Exception
	 */
	public static void localDownload(HttpServletRequest request, HttpServletResponse response, String contentType,
			String realName, String downLoadPath) throws Exception {
		long fileLength = new File(downLoadPath).length();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data" + ";charset=UTF-8");
		response.setHeader("Content-disposition", "attachment; filename=" + new String(realName.getBytes("utf-8"), "ISO-8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[(int) fileLength];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.flush();
		bos.close();
	}

	/**
	 * 将将多个文件写入到zip文件中
	 * 
	 * @param inputFile
	 * @param outputstream
	 * @throws Exception
	 */
	public static void zipFile(List<File> inputFiles, ZipOutputStream outputstream) throws Exception {
		try {
			for (File inputFile : inputFiles) {
				if (inputFile.exists()) {
					if (inputFile.isFile()) {
						FileInputStream inStream = new FileInputStream(inputFile);
						BufferedInputStream bInStream = new BufferedInputStream(inStream);
						ZipEntry entry = new ZipEntry(inputFile.getName());
						outputstream.putNextEntry(entry);

						final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
						long streamTotal = 0; // 接受流的容量
						int streamNum = 0; // 流需要分开的数量
						int leaveByte = 0; // 文件剩下的字符数
						byte[] inOutbyte; // byte数组接受文件的数据

						streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
						streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
						leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

						if (streamNum > 0) {
							for (int j = 0; j < streamNum; ++j) {
								inOutbyte = new byte[MAX_BYTE];
								// 读入流,保存在byte数组
								bInStream.read(inOutbyte, 0, MAX_BYTE);
								outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
							}
						}
						// 写出剩下的流数据
						inOutbyte = new byte[leaveByte];
						bInStream.read(inOutbyte, 0, leaveByte);
						outputstream.write(inOutbyte);
						outputstream.closeEntry(); // Closes the current ZIP
													// entry
						// and positions the stream for
						// writing the next entry
						bInStream.close(); // 关闭
						inStream.close();
					}
				}
			}
			outputstream.close();
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * 创建一个全新的文件夹，如果原来有文件，则将原来的文件删除
	 * 
	 * @param path
	 *            文件路劲
	 */
	public static void createNewDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		} else {
			String[] filelist = file.list();
			for (String d : filelist) {
				File delfile = new File(path + "\\" + d);
				delfile.delete();
			}
		}
	}

	/**
	 * 删除某个文件夹下的所有文件，文件夹任然保留
	 *  
	 * @param delPath
	 *            String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static void deleteFile(String delPath) throws FileNotFoundException, IOException {
		File file = new File(delPath);
		if (!file.isDirectory()) {
			file.delete();
		} else if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(delPath + "\\" + filelist[i]);
				if (!delfile.isDirectory()) {
					delfile.delete();
				} else if (delfile.isDirectory()) {
					deleteFile(delPath + "\\" + filelist[i]);
				}
			}
			//加上这句会将本身的文件夹也删除
//			file.delete();
		}
	}
	
	public static void pageImgTagView(HttpServletResponse response,String imgPath) throws Exception{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		BufferedInputStream bis = null;
		OutputStream os = null;
		FileInputStream fileInputStream = new FileInputStream(new File(imgPath));

		bis = new BufferedInputStream(fileInputStream);
		byte[] buffer = new byte[512];
		response.reset();
		response.setCharacterEncoding("UTF-8");
		// 不同类型的文件对应不同的MIME类型
		response.setContentType("image/*");
		// 文件以流的方式发送到客户端浏览器
		// response.setHeader("Content-Disposition","attachment; filename=img.jpg");
		// response.setHeader("Content-Disposition",
		// "inline; filename=img.jpg");

		response.setContentLength(bis.available());

		os = response.getOutputStream();
		int n;
		while ((n = bis.read(buffer)) != -1) {
			os.write(buffer, 0, n);
		}
		bis.close();
		os.flush();
		os.close();
	}

	public static void main(String[] args) throws Exception {
		deleteFile("C:\\aa");
	}
}
