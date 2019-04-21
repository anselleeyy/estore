package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.ItemDetail;

public interface IItemDetailDao {
	
	/**
	 * 查询某一个商品详情信息
	 * @param id
	 */
	@Select(value = "select * from tb_item_detail where id = #{id}")
	public ItemDetail findById(long id);

}
