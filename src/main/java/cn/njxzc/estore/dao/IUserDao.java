package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.pagehelper.Page;

import cn.njxzc.estore.entity.User;

public interface IUserDao {
	
	/**
	 * 通过用户名查找用户信息
	 * @param username
	 * @return
	 */
	@Select(value = "select * from tb_user where username = #{username}")
	public User findByUsername(String username);
	
	@Insert(value = "insert into tb_user(username, password, phone, email, avatar) values(#{username}, #{password}, #{phone}, #{email}, #{avatar})")
	public void registerNew(User user);
	
	@Update(value = "update tb_user set password = #{password} where id = #{id}")
	public void updatePassword(Long id, String password);
	
	@Select(value = "select * from tb_user where id = #{id}")
	public User findById(Long id);
	
	@Select(value = "select * from tb_user")
	public Page<User> findAll();
	
	@Delete(value = "delete from tb_user where id = #{id}")
	public void deleteUser(long id);
}
