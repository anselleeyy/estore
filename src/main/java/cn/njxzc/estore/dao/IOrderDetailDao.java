package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.OrderDetail;

public interface IOrderDetailDao {
	
	@Insert(value = 
			"insert into tb_order_detail (item_id, order_id, num, title, price, total_fee, pic_url) values (#{itemId}, #{orderId}, #{num}, #{title}, #{price}, #{totalFee}, #{picUrl})")
	public void addDetail(OrderDetail detail);
	
	@Select(value = "select * from tb_order_detail where order_id = #{orderId}")
	public List<OrderDetail> findByOrderId(String orderId);

}
