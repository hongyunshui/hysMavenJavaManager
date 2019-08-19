package com.taotao.service.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.PropertiesUtil;
import com.taotao.service.PictureService;

/**
 * 图片服务
 * @author hys
 *
 */
@Service
public class PictureServiceImp implements PictureService {
	
//	@Value("${FTP_ADDRESS}")
//	private String FTP_ADDRESS;
//	@Value("${FTP_PORT}")
//	private String FTP_PORT;
//	@Value("${FTP_USERNAME}")
//	private String FTP_USERNAME;
//	@Value("${FTP_USERPASSWORD}")
//	private String FTP_USERPASSWORD;
	

	/**
	 * 上传图片
	 * @throws IOException 
	 */
	@Override
	public Map uploadPicture(MultipartFile uploadFile) throws IOException {
		// 创建返回的Map
		Map<Object, Object> result = new HashMap<>();
		result.clear();
		// 生成一个新的文件名
		// 取原始文件名
		String oldName = uploadFile.getOriginalFilename();
		// 生成一个新的名字
//		UUID.randomUUID();
		String newImgName = IDUtils.genImageName();
		// 给新的图片名称加上后缀
		newImgName = newImgName + oldName.substring(oldName.lastIndexOf("."));
		// 获取图片的流数据
		FileInputStream input = (FileInputStream) uploadFile.getInputStream();
		// 获取Ftp配置信息
//		Map<String, String> ftpInfo = (Map<String, String>) PropertiesUtil.getPropertiesFromFile("/resource/resource.properties");
		
		// 图片上传
		boolean flag = FtpUtil.uploadFile("192.168.10.22",21, 
				"ftpuser", "ftpuser", 
				"/home/ftpuser/taotaoftp", "/image", newImgName, input);
		if(!flag){
			result.put("error", 1);
			result.put("url", "图片上ftp传失败");
			System.out.println(result.get("url"));
			return result;
		}
		result.clear();
		result.put("error", 0);
		result.put("url", "ftp://192.168.10.22/taotaoftp/image/" + newImgName);
		System.out.println(result.get("url"));
		return result;
	}

}
