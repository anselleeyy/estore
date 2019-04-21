package cn.njxzc.estore.service;

import cn.njxzc.estore.dto.UserDto;

public interface ILoginService {

	public UserDto userLogin(String username, String password);

	public String checkLogin(String token);

}
