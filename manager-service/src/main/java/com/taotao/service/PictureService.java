package com.taotao.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片服务
 * @author hys
 *
 */
public interface PictureService {

	/**
	 * 上传图片
	 * @param uploadFile
	 * @return
	 * @throws IOException 
	 */
	Map<?, ?> uploadPicture(MultipartFile uploadFile) throws IOException;
}
