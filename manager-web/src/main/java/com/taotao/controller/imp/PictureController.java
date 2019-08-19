package com.taotao.controller.imp;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * 图片管理
 * @author hys
 *
 */
@Controller
public class PictureController {
	
	// 注入图片服务Service
	@Autowired
	private PictureService pictureService;

	//上传图片
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upLoadPicture(MultipartFile uploadFile) throws IOException{
		// 接收页面上传的文件
		Map<?, ?> result = pictureService.uploadPicture(uploadFile);
		// 为了保证功能的兼容性，需要把Result转换成json格式的字符串
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
