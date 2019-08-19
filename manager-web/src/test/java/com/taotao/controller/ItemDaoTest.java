package com.taotao.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.mapper.ItemMapper;
import com.taotao.pojo.Item;

/**
 * 测试自定义itemDa0
 * @author hys
 *
 */
public class ItemDaoTest {
	
private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		// 创建Spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}

	/**
	 * 测试自定selectItemList方法
	 */
	@Test
	public void selectItemListTest() {
		ItemMapper itemMapper = applicationContext.getBean(ItemMapper.class);
		List<Item> itemList = itemMapper.selectItemList();
		int cnt = 0;
		for(Item item:itemList ){
			System.out.println(item.getTitle());
			cnt ++;
			if(cnt > 15) break;
		}
	}

}
