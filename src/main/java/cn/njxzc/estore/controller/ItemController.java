package cn.njxzc.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.njxzc.estore.entity.Item;
import cn.njxzc.estore.service.IItemService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;
import cn.njxzc.estore.utils.UploadUtil;
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
		Response response = new Response(ReturnCode.ITEM_DETAIL_GOT, item);
		return response;
	}
	
    /**
     * 
     * @param type
     *            0: normal | 1: asc | -1: desc
     * @param currentPage
     * @param pageSize
     * @return
     */
	@ApiOperation(value = "分页查询所有的商品", notes = "根据页码和页大小获取所有商品信息")
	@GetMapping(value = "/all/{type}")
	public Object findAllItems(@PathVariable int type, @RequestParam int currentPage, @RequestParam int pageSize) {
		List<Item> list = null;
		if (type == 0) {
			list = itemService.findAllByPage(currentPage, pageSize);
		} else if (type == -1) {
			list = itemService.findAllByPriceDesc(currentPage, pageSize);
		} else if (type == 1) {
			list = itemService.findAllByPriceAsc(currentPage, pageSize);
		}
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		Response response = new Response(ReturnCode.ITEM_LIST_GOT, pageInfo);
		return response;
	}

    @ApiOperation(value = "根据一定价格区间分页查询所有的商品")
    @GetMapping(value = "/all/price/{interval}")
    public Object findItemsBySelectPrice(@RequestParam int currentPage, @RequestParam int pageSize,
        @PathVariable String interval) {
        // 区间必须通过 | 分割
        String[] limits = interval.split("\\|");
        List<Item> list =
            itemService.findAllByPrice(currentPage, pageSize, Integer.valueOf(limits[0]), Integer.valueOf(limits[1]));
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        Response response = new Response(ReturnCode.ITEM_LIST_GOT, pageInfo);
        return response;
    }

    /**
     * 异步服务接口，更新商品点击率
     * 
     * @param id
     * @return
     */
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
	
	/**
	 * 搜索接口
	 * @param keyword
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "/search/{keyword}")
	public Object search(@PathVariable String keyword, @RequestParam int currentPage, @RequestParam int pageSize) {
		List<Item> list = itemService.searchItem(currentPage, pageSize, keyword);
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		Response response = new Response(ReturnCode.ITEM_LIST_GOT, pageInfo);
		return response;
	}
	
	@PostMapping(value = "/upload")
	public Object upload(@RequestParam MultipartFile file, @RequestParam long isbn, @RequestParam int flag) {
		String picUrl = "";
		try {
			picUrl = UploadUtil.savePic(isbn, file, flag);
			return new Response(ReturnCode.FILE_UPLOAD_SUCCEED, picUrl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Response(ReturnCode.FILE_UPLOAD_FAILED, picUrl);
	}
	
	@PostMapping(value = "/add")
	public Object addNew(@RequestBody Item item) {
		Response response = null;
		boolean flag = itemService.saveInfo(item);
		if (flag) {
			response = new Response(ReturnCode.ITEM_ADD_SUCCEED);
		} else {
			response = new Response(ReturnCode.ITEM_ADD_FAILED);
		}
		return response;
	}
	
	/**
     * 
     * 提供管理员查看所有商品，包括下架商品
     * 
     * @param currentPage
     * @param pageSize
     * @return
     */
	@GetMapping(value = "/alls")
	public Object findAllItems(@RequestParam int currentPage, @RequestParam int pageSize) {
		List<Item> list = itemService.findAllItems(currentPage, pageSize);
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		Response response = new Response(ReturnCode.ITEM_LIST_GOT, pageInfo);
		return response;
	}
	
	/**
	 * 删除商品
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public Object deleteItem(@PathVariable long id) {
		boolean flag = itemService.deleteItem(id);
		Response response = null;
		if (flag) {
			response = new Response(ReturnCode.ITEM_DELETE_SUCCEED);
		} else {
			response = new Response(ReturnCode.ITEM_DELETE_FAILED);
		}
		return response;
	}
	
	/**
	 * 更新上下架状态
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/update/status/{id}")
	public Object updateStatus(@PathVariable long id) {
		boolean flag = itemService.updateStatus(id);
		Response response = null;
		if (flag) {
			response = new Response(ReturnCode.ITEM_UPDATE_SUCCEED);
		} else {
			response = new Response(ReturnCode.ITEM_UPDATE_FAILED);
		}
		return response;
	}
	
	/**
	 * 更新库存和单价
	 * 
	 * @param id
	 * @param price
	 * @param limitNum
	 * @return
	 */
	@PutMapping(value = "/update/{id}")
	public Object updateInfo(@PathVariable long id, @RequestBody Item item) {
		double price = item.getPrice();
		int limitNum = item.getItemDetail().getLimitNum();
		boolean flag = itemService.updateNumAndPrice(id, price, limitNum);
		Response response = null;
		if (flag) {
			response = new Response(ReturnCode.ITEM_UPDATE_SUCCEED);
		} else {
			response = new Response(ReturnCode.ITEM_UPDATE_FAILED);
		}
		return response;
	}
}