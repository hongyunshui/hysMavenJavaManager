package com.taotao.controller;

import org.junit.Test;

import com.taotao.common.utils.IDUtils;

/**
 * ID 工具类测试
 * @author hys
 *
 */
public class IDUtilsTest {
	
	@Test
	public void genImageNameTest(){
		String imgName = IDUtils.genImageName();
		System.out.println(imgName);
	}

}
