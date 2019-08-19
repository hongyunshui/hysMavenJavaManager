package com.taotao.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.controller.ItemCatController;
import com.taotao.service.ItemCatService;

/**
 * 商品分类管理controller
 * @author hys
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatControllerImp implements ItemCatController {
	
	@Autowired
	public ItemCatService itemCatService;
	
	/**
	 * 查询类目
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getItemCatByParentId(@RequestParam(value="id", defaultValue="0") long parentId){
		List<EUTreeNode> etn = itemCatService.getCatList(parentId);
		return etn;	
	}

	@Override
	public void test() {
		System.out.println("test jiekou");
		
	}
}
