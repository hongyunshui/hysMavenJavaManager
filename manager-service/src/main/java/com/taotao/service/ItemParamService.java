package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.RespResult;

/**
 * 商品规格参数服务
 * @author hys
 *
 */
public interface ItemParamService {
	
	// 获取商品规格参数列表
	EUDataGridResult getItemParamList(int page, int rows);
	
	RespResult getItemParamByCid(long id);
}
