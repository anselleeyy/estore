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

	public boolean delete(int id);

	public boolean updateNum(int num, int id);
	
	boolean orderCart(Long userId);
	
	boolean insertCart(Cart cart);

}
