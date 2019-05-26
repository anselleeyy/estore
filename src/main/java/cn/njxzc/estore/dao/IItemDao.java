package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Item;

public interface IItemDao {
	
	/**
	 * 搜索所有的上架商品信息
	 * @return
	 */
	@Select(value = "select * from tb_item where status = 1")
	public List<Item> findAll();
	
	/**
	 * 分页查询所有的商品信息
	 * @return
	 */
	@Select(value = "select * from tb_item where status = 1")
	public Page<Item> findAllByPage();
	
	/**
	 * 分页查询所有的商品信息
	 * 管理员用
	 * 
	 * @return
	 */
	@Select(value = "select * from tb_item")
	public Page<Item> findAllItems();
	
	/**
	 * 分页降序查询
	 * @return
	 */
	@Select(value = "select * from tb_item where status = 1 order by price desc")
	public Page<Item> findItemByPriceDesc();
    
	/**
     * 分页升序查询
     * @return
     */
    @Select(value = "select * from tb_item where status = 1 order by price asc")
    public Page<Item> findItemByPriceAsc();
    
    /**
     * 分页按价格区间查询
     * @return
     */
    @Select(value = "select * from tb_item where price >= #{low} and price <= #{high} and status = 1")
    public Page<Item> findItemByPrice(int low, int high);
	
	/**
	 * 根据浏览量排序获取热搜图书
	 * @return
	 */
	@Select(value = "select * from tb_item where status = 1 order by hot_rate desc limit 12")
	public List<Item> findHotItems();
	
	@Select(value = "select * from tb_item where id = #{id}")
	@ResultMap(value = "cn.ltysyn.estore.item.dao.ItemDao.ItemResult")
	public Item findItemById(long id);
	
	@Update(value = "update tb_item set hot_rate = hot_rate + 1 where id = #{id}")
	public void updateHotRate(long id);
	
	/**
	 * 根据关键字搜索接口
	 * 
	 * @param keyword
	 * @return
	 */
	@Select(value = "select * from tb_item where title like #{keyword}")
	public Page<Item> searchItem(String keyword);
	
	/**
	 * 新增商品
	 * 
	 * @param item
	 */
	@Insert(value = "insert into tb_item(id, title, author, price, publisher, pic_url) values (#{id}, #{title}, #{author}, #{price}, #{publisher}, #{picUrl})")
	public void save(Item item);
	
	/**
	 * 商品上下架接口
	 * 
	 * @param id
	 */
	@Update(value = "update tb_item set status = (case when status = 1 then 0 else 1 END) where id = #{id}")
	public void updateStatus(long id);
	
	/**
	 * 商品单价修改接口
	 * 
	 * @param price
	 * @param id
	 */
	@Update(value = "update tb_item set price = #{price} where id = #{id}")
	public void updatePrice(double price, long id);
	
	/**
	 * 商品删除接口
	 * 
	 * @param id
	 */
	@Delete(value = "delete from tb_item where id = #{id}")
	public void deleteItem(long id);

}
