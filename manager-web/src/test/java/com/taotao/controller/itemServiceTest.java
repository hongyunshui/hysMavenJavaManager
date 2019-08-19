package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.Item;
import com.taotao.service.ItemService;

/**
 * 商品service测试
 * @author hys
 *
 */
public class itemServiceTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		// 创建Spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}

	/**
	 * 获取商品列表测试getItemList
	 */
	@Test
	public void getItemListTest() {
		// 获取ItemService对象
		ItemService itemService = applicationContext.getBean(ItemService.class);
		
		// 获取easyUI对象
		EUDataGridResult itemListView  = itemService.getItemList(2, 6);
		long total = itemListView.getTotal();
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) itemListView.getRows();
		System.out.println("商品总数是： " + total);
		System.out.println("查询出的当前页面信息为： " );
		int cnt = 0;
		for(Item item:itemList){
			System.out.println(item.getTitle());
			cnt ++;
			if(cnt > 10) break;
		}
	}

}
