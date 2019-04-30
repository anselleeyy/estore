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
     * 
     * @param userId
     * @return
     */
	@Select("select * from tb_cart where user_id = #{userId} and status = 1")
	public List<Cart> findAll(Long userId);
	
    /**
     * 根据 userId 和 itemId 查找用户是否存在这条购物车记录
     * 
     * @param userId
     *            用户 id
     * @param itemId
     *            商品 id
     * @return
     */
	@Select("select * from tb_cart where user_id = #{userId} and item_id = #{itemId} and status = 1")
	public Cart findIfExist(Long userId, Long itemId);
	
    /**
     * 通过 id 来删除一条购物车商品记录
     * 
     * @param itemId
     */
	@Delete("delete from tb_cart where id = #{id}")
	public void delete(int id);
	
    /**
     * 通过 itemId 和 UserId 来删除一条购物车商品记录
     * 
     * @param itemId
     * @param userId
     */
    @Delete("delete from tb_cart where user_id = #{userId} and item_id = #{itemId}")
    public void deleteCart(long userId, long itemId);
	
    /**
     * 通过 id 更新商品数量
     * 
     * @param num
     * @param id
     * @return
     */
	@Update(value = "update tb_cart set number = number + #{num} where id = #{id}")
	public void updateNumById(int num, int id);
	
	/**
	 * 通过 userId 和 itemId 更新商品数量
	 * @param num
	 * @param itemId
	 * @param userId
	 */
    @Update(value = "update tb_cart set number = number + #{num} where user_id = #{userId} and item_id = #{itemId}")
    public void updateNum(int num, long itemId, long userId);
	
	/**
	 * 更新用户购物车状态为订单状态
	 * @param userId
	 */
	@Update(value = "update tb_cart set status = 0 where user_id = #{userId}")
	void orderCart(Long userId);
	
	@Insert(value = "insert into tb_cart(user_id, item_id, number) values (#{userId}, #{itemId}, #{number})")
	void insertNewRec(Cart cart);

}
