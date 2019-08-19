package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.PropertiesUtil;

/**
 * ftp 相关测试
 * @author hys
 *
 */
public class FTPTest {

	/**
	 * ftp上传文件方法 测试
	 * @throws Exception
	 */
	@Test
	public void testFtpClient() throws Exception{
		// 创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接
		ftpClient.connect("192.168.10.22", 21);
		// 登陆ftp服务器 使用用户名和密码
		ftpClient.login("ftpuser", "ftpuser");
		// 上传文件
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("E:\\files\\Home\\Entertainment\\Pictures\\alien\\外星人5.jpg"));
		// 设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/taotaoftp/image/");
		// 修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数是服务器端文件名，第二个参数是本地文件io流
		ftpClient.storeFile("remoteFileName1.jpg", inputStream);
		
		// 关闭文件
	}
	
	/**
	 * ftp工具类上传文件测试
	 * @throws FileNotFoundException
	 */
	@Test
	public void testFtpUtil() throws FileNotFoundException{
		FileInputStream input = new FileInputStream(new File("E:\\files\\Home\\Entertainment\\Pictures\\alien\\外星人5.jpg"));
		FtpUtil.uploadFile("192.168.10.22", 21, "ftpuser", "ftpuser", "/home/ftpuser/taotaoftp/image", "/2019/08/25", "remoteFileName3.jpg", input);
	}
	
	/**
	 * 读取配置参数测试
	 * @throws IOException
	 */
	@Test
	public void testFTPproperties() throws IOException{
		Properties pro = new Properties();
		InputStream  in = Object.class.getResourceAsStream("/resource/resource.properties");
		pro.load(in);// 加载属性列表
		Iterator<String> it = pro.stringPropertyNames().iterator();
		Map<String, String> propMap = new HashMap<String, String>();
		while(it.hasNext()){
			String key=it.next();
			System.out.println(key + ":" + pro.getProperty(key));
			propMap.put(key, pro.getProperty(key));
		}
		in.close();
		
		System.out.println("******************");
		
		for(Entry<String, String> entry : propMap.entrySet()){
		    String mapKey = entry.getKey();
		    String mapValue = entry.getValue();
		    System.out.println(mapKey+":"+mapValue);
		}
	}
	
	/**
	 * 测试配置文件工具类
	 */
	@Test
	public void testPropertiesUtil(){
		System.out.println("测试配置文件工具类");
		String path = "/resource/resource.properties";
		try {
			Map<String, String> propMap = (Map<String, String>) PropertiesUtil.getPropertiesFromFile(path);
			for(Entry<String, String> entry : propMap.entrySet()){
			    String mapKey = entry.getKey();
			    String mapValue = entry.getValue();
			    System.out.println(mapKey+":"+mapValue);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * service 层上传图片服务测试
	 */
	@Test
	public void testUploadPicture(){
		
		// 创建MultipartFile对象
		
		// 创建PictureServiceImp对象
		// 打印返回结果
		
	}
}
