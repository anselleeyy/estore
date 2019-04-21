package cn.njxzc.estore.dto;

import java.io.Serializable;

import cn.njxzc.estore.entity.User;

public class UserDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6613966027601581473L;

	private User user;

	private String message;

	private String token;

	private int state = 0;

	public UserDto() {
		super();
	}

	public UserDto(User user, String message, String token) {
		super();
		this.user = user;
		this.message = message;
		this.token = token;
	}

	public UserDto(User user, String message, String token, int state) {
		super();
		this.user = user;
		this.message = message;
		this.token = token;
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
