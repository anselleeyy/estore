package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.njxzc.estore.entity.OrderDetail;

public interface IOrderDetailDao {
	
	/**
	 * 新建订单明细的接口
	 * 
	 * @param detail
	 */
	@Insert(value = 
			"insert into tb_order_detail (item_id, order_id, num, title, price, total_fee, pic_url) values (#{itemId}, #{orderId}, #{num}, #{title}, #{price}, #{totalFee}, #{picUrl})")
	public void addDetail(OrderDetail detail);
	
	/**
	 * 根据订单查询订单明细的接口
	 * 
	 * @param orderId
	 * @return
	 */
	@Select(value = "select * from tb_order_detail where order_id = #{orderId}")
	public List<OrderDetail> findByOrderId(String orderId);
	
	/**
	 * 更新订单的单价和数量的接口
	 * 
	 * @param orderId
	 * @param num
	 * @param price
	 * @param totalFee
	 */
	@Update(value = "update tb_order_detail set num = #{num}, price = #{price}, total_fee = #{totalFee} where order_id = #{orderId}")
	public void updateInfo(String orderId, Integer num, Double price, Double totalFee);
	
	/**
	 * 删除订单详情
	 * 
	 * @param orderId
	 */
	@Delete(value = "delete from tb_order_detail where order_id = #{orderId}")
	public void deleteDetail(String orderId);

}
