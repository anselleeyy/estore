package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Order;

public interface IOrderDao {

	/**
	 * 创建订单接口
	 * 
	 * @param order
	 */
	@Insert(value = "insert into tb_order (order_id, payment, user_id, address_id) values (#{orderId}, #{payment}, #{userId}, #{addressId})")
	public void createOrder(Order order);
	
	/**
	 * 提供用户查询自己订单的接口
	 * 
	 * @param userId
	 * @return
	 */
	@Select(value = "select * from tb_order where user_id = #{userId}")
	public Page<Order> findByUserId(Long userId);
	
	/**
	 * 提供管理员查看订单的接口
	 * 
	 * @return
	 */
	@Select(value = "select * from tb_order")
	public Page<Order> findAllByPage();
	
	/**
	 * 根据 orderId 删除订单的接口
	 * 
	 * @param orderId
	 */
	@Delete(value = "delete from tb_order where order_id = #{orderId}")
	public void delete(String orderId);

}
