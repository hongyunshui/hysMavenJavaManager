package com.taotao.controller;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

/**
 * 商品分类管理Controller
 * @author hys
 *
 */
public interface ItemCatController {
	// 查询类目
	List<EUTreeNode> getItemCatByParentId(long parentId);
	public void test();
}
