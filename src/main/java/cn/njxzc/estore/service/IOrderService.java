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
	
	/**
	 * 提供管理员修改订单的单件商品的数量和单价
	 * 注意更新明细表的总额和整笔订单的总额
	 * 
	 * @param orderId
	 * @param num
	 * @param price
	 * @return
	 */
	public boolean updatePriceAndNum(String orderId, Integer num, Double price);
	
	/**
	 * 删除订单以及明细
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean deleteOrder(String orderId);

}
