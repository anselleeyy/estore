package cn.njxzc.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.njxzc.estore.entity.Item;
import cn.njxzc.estore.service.IItemService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = { "Item" })
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@ApiOperation(value = "获取热度最高的 12 个商品")
	@GetMapping(value = "/hot")
	public Object findHotItems() {
		List<Item> items = itemService.findHotItems();
		return items;
	}
	
	@ApiOperation(value = "获取某个商品的所有信息", notes = "根据商品 id 获取商品信息")
	@GetMapping(value = "/detail/{id}")
	public Object findItemById(@PathVariable long id) {
		Item item = itemService.findItemById(id);
		return item;
	}
	
	@ApiOperation(value = "分页查询所有的商品", notes = "根据页码和页大小获取所有商品信息")
	@GetMapping(value = "/all")
	public Object findAllItems(@RequestParam int currentPage, @RequestParam int pageSize) {
		List<Item> list = itemService.findAllByPage(currentPage, pageSize);
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		Response response = new Response(ReturnCode.ITEM_LIST_GOT, pageInfo);
		return response;
	}
	
	@ApiOperation(value = "点击后更新商品热度")
	@PutMapping(value = "/updateHot/{id}")
	public Object updateHotRate(@PathVariable Long id) {
		boolean flag = itemService.updateHotRate(id);
		Response response = new Response();
		if (flag) {
			response.setReturnCode(ReturnCode.ITEM_HOT_RATE_UPDATE);
		}
		return response;
	}
}