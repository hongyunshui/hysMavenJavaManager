package com.taotao.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.service.ItemParamService;

/**
 * 管理商品规格
 * @author hys
 *
 */
@Controller
public class ItemParamControllerImp {
	
	@Autowired
	private ItemParamService itemParamService;
	
	/**
	 * 查询商品规格参数列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/param/list")
	@ResponseBody
	private EUDataGridResult getItemParamItemList(Integer page, Integer rows){
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		return result;
	}

}
