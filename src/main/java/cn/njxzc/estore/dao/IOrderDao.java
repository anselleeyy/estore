package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.Order;

public interface IOrderDao {

	@Insert(value = "insert into tb_order (order_id, payment, user_id, address_id) values (#{orderId}, #{payment}, #{userId}, #{addressId})")
	public void createOrder(Order order);
	
	@Select(value = "select * from tb_order where user_id = #{userId}")
	public Page<Order> findByUserId(Long userId);
	
	@Select(value = "select * from tb_order")
	public Page<Order> findAllByPage();

}
