package cn.njxzc.estore.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Item;
import cn.njxzc.estore.entity.ItemDetail;

public interface IItemService {
	
	public List<Item> findItems();
	
	/**
	 * 获取12个热搜图书，展现在首页
	 * @return
	 */
	public List<Item> findHotItems();
	
	/**
	 * 通过 id 查询商品详情
	 * @param id
	 */
	public ItemDetail findDetailById(long id);
	
	public Item findItemById(long id);
	
	/**
	 * 分页查询商品信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Item> findAllByPage(int pageNo, int pageSize);
	
	/**
     * 分页降序查询商品信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Item> findAllByPriceDesc(int pageNo, int pageSize);
    
    /**
     * 分页升序查询商品信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Item> findAllByPriceAsc(int pageNo, int pageSize);
    
    /**
     * 分页按照价格区间查询商品信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Item> findAllByPrice(int pageNo, int pageSize, int low, int high);
	
	/**
	 * 更新商品热度
	 * @param id
	 */
	public boolean updateHotRate(Long id);
	
	/**
	 * 搜索商品
	 * @param pageNo
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public Page<Item> searchItem(int pageNo, int pageSize, String keyword);
	
	/**
	 * 新增商品信息
	 * 上传用
	 * 
	 * @param item
	 * @return
	 */
	public boolean saveInfo(Item item);
	
	/**
	 * 提供给管理员进行分页查询的接口，查询包括下架的所有商品
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Item> findAllItems(int pageNo, int pageSize);
	
	/**
	 * 提供给管理员进行商品上下架
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateStatus(long id);
	
	/**
	 * 提供管理员更新商品的库存和单价
	 * 
	 * @param id
	 * @param price
	 * @param limitNum
	 * @return
	 */
	public boolean updateNumAndPrice(long id, double price, int limitNum);
	
	/**
	 * 提供管理员删除商品
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteItem(long id);
	
}
