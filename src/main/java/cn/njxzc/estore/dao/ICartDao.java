package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.njxzc.estore.entity.Cart;

public interface ICartDao {
	
	/**
	 * 查找一个用户的购物车内容
	 * @param userId
	 * @return
	 */
	@Select("select * from tb_cart where user_id = #{userId} and status = 1")
	public List<Cart> findAll(Long userId);
	
	/**
	 * 通过 id 来删除一条购物车商品记录
	 * @param itemId
	 */
	@Delete("delete from tb_cart where id = #{id}")
	public void delete(int id);
	
	/**
	 * 通过 id 更新商品数量
	 * @param num
	 * @param id
	 * @return
	 */
	@Update(value = "update tb_cart set number = #{num} where id = #{id}")
	public void updateNum(int num, int id);
	
	/**
	 * 更新用户购物车状态为订单状态
	 * @param userId
	 */
	@Update(value = "update tb_cart set status = 0 where user_id = #{userId}")
	void orderCart(Long userId);
	
	@Insert(value = "insert into tb_cart(user_id, item_id) values (#{userId}, #{itemId})")
	void insertNewRec(Cart cart);

}
