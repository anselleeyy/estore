package cn.njxzc.estore.utils;

public enum ReturnCode {
	
	// 商品相关
	ITEM_LIST_GOT(10001, "商品列表获取成功"),
	
	ITEM_HOT_RATE_UPDATE(10002, "商品热度更新成功"),
	
	ITEM_DETAIL_GOT(10003, "商品信息读取成功"),
	
	// 购物车相关
	CART_ADD_SUCCEED(20001, "购物车记录添加成功"),
	
	CART_ADD_FAILED(20002, "购物车记录添加失败"),
	
	CART_LIST_GOT(20003, "用户购物车记录读取成功"),
	
	CART_DELETE_SUCCEED(20004, "购物车记录删除成功"),
    
    CART_DELETE_FAILED(20005, "购物车记录删除失败"),
    
    CART_UPDATE_SUCCEED(20006, "购物车记录更新成功"),
    
    CART_UPDATE_FAILED(20007, "购物车记录更新失败"),
	
	// 用户相关
	USER_CREATE_SUCCEED(40001, "用户注册成功"),
	
	USER_REGISTER_ERROR(40002, "用户注册失败，请稍后重试"),
	
	USER_LOGIN_SUCCEED(40003, "用户登录成功"),
	
	USER_LOGIN_FAILED(40004, "用户登录失败，用户名或密码有误"),
	
	USER_LOGIN_STATUS_CHECKED(40005, "用户处于登录态"),
	
	USER_PASSWORD_SUCCEED(40006, "用户密码修改成功"),
	
	USER_PASSWORD_FAILED(40007, "用户密码修改失败"),
	
	USER_LOGOUT_SUCCEED(40008, "用户退出成功"),
	
	USER_LOGOUT_FAILED(40009, "用户退出失败"),
	
	// Geetest
	GEETEST_VERIFY_FAILED(50001, "极验验证失败"),
	
	// 地址相关
	ADDRESS_LIST_GOT(60001, "用户地址列表获取成功"),
	
	ADDRESS_ADD_SUCCEED(60002, "用户地址添加成功"),
    
    ADDRESS_ADD_FAILED(60003, "用户地址添加失败"),
	
	ADDRESS_UPDATE_SUCCEED(60004, "用户地址更新成功"),
	
	ADDRESS_UPDATE_FAILED(60005, "用户地址更新失败"),
	
	ADDRESS_DELETE_SUCCEED(60006, "用户地址删除成功"),
    
    ADDRESS_DELETE_FAILED(60007, "用户地址删除失败"),
    
    // 订单相关
    ORDER_CREATE_SUCCEED(70001, "订单创建成功"),
    
    ORDER_CREATE_FAILED(70002, "订单创建失败"),
    
    ORDER_LIST_GOT(70003, "订单信息获取成功");
	
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
