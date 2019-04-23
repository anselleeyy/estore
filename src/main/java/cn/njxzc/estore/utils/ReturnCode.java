package cn.njxzc.estore.utils;

public enum ReturnCode {
	
	// 商品相关
	ITEM_LIST_GOT(10001, "商品列表获取成功"),
	
	ITEM_HOT_RATE_UPDATE(10002, "商品热度更新成功"),
	
	// 用户相关
	USER_CREATE_SUCCEED(40001, "用户注册成功"),
	
	USER_REGISTER_ERROR(40002, "用户注册失败，请稍后重试"),
	
	USER_LOGIN_SUCCEED(40003, "用户登录成功"),
	
	USER_LOGIN_FAILED(40004, "用户登录失败，用户名或密码有误"),
	
	USER_LOGIN_STATUS_CHECKED(40005, "用户处于登录态"),
	
	USER_PASSWORD_SUCCEED(40006, "用户密码修改成功"),
	
	USER_PASSWORD_FAILED(40007, "用户密码修改失败"),
	
	// Geetest
	GEETEST_VERIFY_FAILED(50001, "极验验证失败");
	
	private int code;
	
	private String message;
	
	private ReturnCode(int code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
