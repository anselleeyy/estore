package cn.njxzc.estore.service;

import java.util.List;

import cn.njxzc.estore.entity.Cart;

public interface ICartService {

	public List<Cart> findAllCarts(Long userId);

	public boolean delete(int id);

	public boolean updateNum(int num, int id);
	
	boolean orderCart(Long userId);
	
	boolean insertCart(Cart cart);

}
