package com.taotao.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.common.pojo.EUTreeNode;

public class ItemCatControllerTest {
	
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}

	@Test
	public void testGetItemCatByParentId() {
		ItemCatController itemCatController = applicationContext.getBean(ItemCatController.class);
		List<EUTreeNode> eutnList = itemCatController.getItemCatByParentId(0);
		System.out.println(eutnList);
	}

}
