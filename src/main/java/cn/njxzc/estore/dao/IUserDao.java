package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.User;

public interface IUserDao {
	
	/**
	 * 通过用户名查找用户信息
	 * @param username
	 * @return
	 */
	@Select(value = "select * from tb_user where username = #{username}")
	public User findByUsername(String username);

}
