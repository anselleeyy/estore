package cn.njxzc.estore.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDao {
	
	@Autowired
	private StringRedisTemplate template;
	
	public void setKey(String key, String value) {
		ValueOperations<String, String> ops = template.opsForValue();
		ops.set(key, value);
	}
	
	public void setKey(String key, String value, int expire) {
		ValueOperations<String, String> ops = template.opsForValue();
		ops.set(key, value, expire, TimeUnit.SECONDS);
	}
	
	public String get(String key) {
		ValueOperations<String, String> ops = template.opsForValue();
		return ops.get(key);
	}
	
	public void delKey(String key) {
		try {
			template.delete(key);			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}