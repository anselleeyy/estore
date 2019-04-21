package cn.njxzc.estore.dto;

import java.io.Serializable;

public class UserValidate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1591854739107392535L;

	private String username;
	
	private String password;
	
	private String challenge;
	
	private String validate;
	
	private String seccode;
	
	private String statusKey;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getSeccode() {
		return seccode;
	}

	public void setSeccode(String seccode) {
		this.seccode = seccode;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}
	
}
