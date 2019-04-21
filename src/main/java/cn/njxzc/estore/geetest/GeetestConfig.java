package cn.njxzc.estore.geetest;

public class GeetestConfig {
	
	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "332253d1e73e9cd540f616832e80879f";
	private static final String geetest_key = "406b17adf6f4f22d5d60a163fd451c5c";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

	public static final boolean isnewfailback() {
		return newfailback;
	}
}
