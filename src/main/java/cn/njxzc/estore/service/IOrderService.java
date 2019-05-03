package cn.njxzc.estore.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Order;

public interface IOrderService {
	
	public boolean createOrder(Order order);
	
	/**
	 * 用户查询自己的订单
	 * @param userId
	 * @return
	 */
	public List<Order> findByUserId(int pageNo, int pageSize, Long userId);
	
	/**
	 * 后台分页查询所有订单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Order> findAllByPage(int pageNo, int pageSize);

}
