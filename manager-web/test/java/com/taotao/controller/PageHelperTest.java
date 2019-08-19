package com.taotao.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import com.taotao.service.imp.ItemServiceImp;

/**
 * 分页测试
 * @author hys
 *
 */
public class PageHelperTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		// 创建Spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	
	@Test
	public void testPageHelper(){
		// 从spring容器中获得Mapper的代理对象
		TbItemMapper tbItemMapper = (TbItemMapper) applicationContext.getBean(TbItemMapper.class);
		// 执行查询并分页
		TbItemExample example = new TbItemExample();
		// 分页处理
		PageHelper.startPage(20, 5, true);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		// 取商品列表
		for(TbItem tbItem:list){
			System.out.println(tbItem.getTitle());
		}
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("商品数量： "  + total);
	}

}
