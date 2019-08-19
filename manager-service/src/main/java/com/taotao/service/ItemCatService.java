package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

public interface ItemCatService {
	
	// 类目查询
	List<EUTreeNode> getCatList(long parentId);

}
