package com.taotao.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.ItemParamMapper;
import com.taotao.pojo.ItemParam;
import com.taotao.service.ItemParamService;

@Service
public class ItemParamServiceImp implements ItemParamService {
	
	@Autowired
	private ItemParamMapper itemParamMapper;
	
	
	/**
	 * 商品规格参数列表查询
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public EUDataGridResult getItemParamList(int page, int rows) {
		// 查询商品规格列表信息 并作分页处理
		PageHelper.startPage(page, rows);
		List<ItemParam> itemParamList = itemParamMapper.selectItemParamList();
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(itemParamList);
		// 获得总记录数
		PageInfo<ItemParam> pageInfo = new PageInfo<>(itemParamList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
