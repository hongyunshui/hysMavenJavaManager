package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;

/**
 * 商品规格参数服务
 * @author hys
 *
 */
public interface ItemParamService {
	
	// 获取商品规格参数列表
	EUDataGridResult getItemParamList(int page, int rows);
}
