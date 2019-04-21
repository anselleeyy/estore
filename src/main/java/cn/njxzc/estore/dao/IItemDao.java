package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Item;

public interface IItemDao {
	
	/**
	 * 搜索所有的商品信息
	 * @return
	 */
	@Select(value = "select * from tb_item")
	public List<Item> findAll();
	
	/**
	 * 分页查询所有的商品信息
	 * @return
	 */
	@Select(value = "select * from tb_item")
	public Page<Item> findAllByPage();
	
	/**
	 * 根据浏览量排序获取热搜图书
	 * @return
	 */
	@Select(value = "select * from tb_item order by hot_rate desc limit 12")
	public List<Item> findHotItems();
	
	@Select(value = "select * from tb_item where id = #{id}")
	@ResultMap(value = "cn.ltysyn.estore.item.dao.ItemDao.ItemResult")
	public Item findItemById(long id);

}
