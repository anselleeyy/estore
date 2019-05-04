package cn.njxzc.estore.service;

import com.github.pagehelper.Page;

import cn.njxzc.estore.dto.UserDto;
import cn.njxzc.estore.entity.User;

public interface IUserService {

	public UserDto userLogin(String username, String password);

	public String checkLogin(String token);
	
	public boolean updatePassword(Long id, String oldPassword, String newPassword);
	
	public boolean insertNew(User user);
	
	public boolean logout(String token);
	
	public Page<User> getAllByPage(int pageNo, int pageSize);
	
	public boolean deleteUser(long id);

}
