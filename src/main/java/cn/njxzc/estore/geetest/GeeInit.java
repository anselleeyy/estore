package cn.njxzc.estore.geetest;

import java.io.Serializable;

public class GeeInit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2850949802831295052L;

	private int success;
	
	private String challenge;
	
	private String gt;
	
	private String statusKey;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

}
