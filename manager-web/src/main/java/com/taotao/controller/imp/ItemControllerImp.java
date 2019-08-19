package com.taotao.controller.imp;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.RespResult;
import com.taotao.controller.ItemController;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理Controller
 * @author hys
 *
 */
@Controller
public class ItemControllerImp implements ItemController  {
	
	@Autowired
	private ItemService itemService;

	/**
	 * 通过id查询商品信息
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		if(tbItem != null){
			return tbItem;
		}
		return null;
	}
	
	/**
	 * 查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows){
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 保存商品信息
	 * @param item
	 * @param desc
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private RespResult createItem(TbItem item, String desc) throws Exception{
		RespResult itemMsg = itemService.createItem(item, desc);
		return itemMsg;
	}
	
	/**
	 * 查询商品规格参数列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/param/list")
	@ResponseBody
	private EUDataGridResult getItemParamItemList(Integer page, Integer rows){
		EUDataGridResult result = itemService.getItemParamItemList(page, rows);
		return result;
	}

}
