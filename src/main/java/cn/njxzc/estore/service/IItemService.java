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
	
}
