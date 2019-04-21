package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.Address;

public interface IAddressDao {

	@Select(value = "select * from tb_order_address where user_id = #{userId}")
	public List<Address> getAddresses(Long userId);
	
}
