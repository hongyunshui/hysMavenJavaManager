package com.taotao.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

/**
 * 商品类目service层测试
 * @author hys
 *
 */
public class ItemCatServiceTest {
private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		// 创建Spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}

	/**
	 * 查询商品列表测试
	 */
	@Test
	public void testGetCatList() {
		ItemCatService itemCatService = applicationContext.getBean(ItemCatService.class);
		List<EUTreeNode> eutnList = itemCatService.getCatList(1);
		for(EUTreeNode eutn:eutnList){
			System.out.println(eutn.getId() + " " + eutn.getState() + " " + eutn.getText());
		}
	}

}
