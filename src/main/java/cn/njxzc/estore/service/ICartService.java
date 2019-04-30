package cn.njxzc.estore.service;

import java.util.List;

import cn.njxzc.estore.entity.Cart;

public interface ICartService {

	/**
	 * 根据 userId 查询用户的所有购物车商品信息(status=1)
	 * @param userId
	 * @return
	 */
	public List<Cart> findAllCarts(Long userId);

	public boolean delete(long userId, long itemId);

	public boolean updateNum(int num, int id);
	
	public boolean updateNum(int num, long itemId, long userId);
	
	boolean orderCart(Long userId);
	
	/**
	 * 主要用于初始登录态的一个数据同步和新增购物车记录
	 * @param cartList
	 * @return
	 */
	boolean insertCart(List<Cart> cartList);

}
