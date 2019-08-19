package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.RespResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	// 通过id 查询商品信息
	TbItem getItemById(long itemId);
	
	// 获取商品列表
	EUDataGridResult getItemList(int page, int rows);
	
	// 获取商品规格参数列表
	EUDataGridResult getItemParamItemList(int page, int rows);
	
	// 插入新的商品信息，返回RespResult
	RespResult createItem(TbItem item,String desc) throws Exception;
	
}
