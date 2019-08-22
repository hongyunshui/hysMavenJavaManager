package com.taotao.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.RespResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.ItemMapper;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

/**
 * 商品管理service
 * @author hys
 *
 */
@Service
public class ItemServiceImp implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	@Autowired 
	private ItemMapper itemMapper;

	/**
	 * 通过id查询商品信息
	 */
	@Override
	public TbItem getItemById(long itemId) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		if(tbItem != null){
			return tbItem;
		}
		return null;
	}


	/**
	 * 商品列表查询
	 */
	/*@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> itemList = tbItemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(itemList);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
		result.setTotal(pageInfo.getTotal());
		return result;
			
	}*/
	
	/**
	 * 商品列表查询
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows){
		// 查询商品列表信息 并作分页处理
		PageHelper.startPage(page, rows);
		List<Item> itemList = itemMapper.selectItemList();
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(itemList);
		// 获得总记录数
		PageInfo<Item> pageInfo = new PageInfo<>(itemList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

	/**
	 * 添加商品
	 */
	@Override
	public RespResult createItem(TbItem item, String desc) throws Exception {
		// item补全
		// 生成商品ID
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// 商品的状态， 1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		// 插入到数据库
		tbItemMapper.insert(item);
		//添加商品描述
		RespResult resu = insertItemDesc(desc,itemId);
		if(resu.getStatus() != 200){
			throw new Exception();
		}
		return RespResult.ok();
	}
	
	/**
	 * 添加商品描述
	 * @param desc
	 * @return
	 */
	private RespResult insertItemDesc(String desc, long itemId){
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		tbItemDesc.setItemId(itemId);
		tbItemDescMapper.insert(tbItemDesc);
		return RespResult.ok();
	}

}
