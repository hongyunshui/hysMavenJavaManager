package com.taotao.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImp implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		//创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 根据条件查询
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);
		// 把列表转换成treeNOdeList
		List<EUTreeNode> resultList = new ArrayList<>();
		for(TbItemCat tbItemCat:tbItemCatList){
			EUTreeNode tn = new EUTreeNode();
			tn.setId(tbItemCat.getId());
			tn.setState(tbItemCat.getIsParent()?"closed":"open");
			tn.setText(tbItemCat.getName());
			resultList.add(tn);
		}
		return resultList;
	}

}
