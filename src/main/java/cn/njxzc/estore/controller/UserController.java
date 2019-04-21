package cn.njxzc.estore.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.njxzc.estore.dto.PasswordDto;
import cn.njxzc.estore.dto.UserDto;
import cn.njxzc.estore.dto.UserValidate;
import cn.njxzc.estore.entity.User;
import cn.njxzc.estore.geetest.GeeInit;
import cn.njxzc.estore.geetest.GeetestConfig;
import cn.njxzc.estore.geetest.GeetestLib;
import cn.njxzc.estore.service.IUserService;
import cn.njxzc.estore.utils.RedisDao;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/login")
	public Object putValue(UserValidate userValidate) {

		// 极验验证
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
				GeetestConfig.isnewfailback());
		
		String challenge = userValidate.getChallenge();
		String validate = userValidate.getValidate();
		String seccode = userValidate.getSeccode();
		
		int gt_server_status_code = Integer.parseInt(redisDao.get(userValidate.getStatusKey()));
		
		// 自定义参数，可以选择添加
		HashMap<String, String> param = new HashMap<>();
		
		int gt_result = 0;
		
		if (gt_server_status_code == 1) {
			// gt-server 正常，向 gt-server 进行二次验证
			gt_result = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
		} else {
			// gt-server 非正常情况下，进行 failback 进行二次验证
		}

		UserDto userDto = new UserDto();
		if (gt_result == 1) {
			userDto = userService.userLogin(userValidate.getUsername(), userValidate.getPassword());
		} else {
			// 验证失败
			userDto.setState(0);
			userDto.setMessage("验证失败");
		}
		Response response = new Response(ReturnCode.USER_LOGIN_SUCCEED, userDto);
		
		return response;
	}
	
	@GetMapping(value = "/geetestInit")
	public Object geetestInit() {
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(), 
				GeetestConfig.isnewfailback());
		String resStr = "{}";
		
		// 自定义参数，可选择添加
		HashMap<String, String> param = new HashMap<>();
		
		// 进行极验预处理
		int gtServerStatus = gtSdk.preProcess(param);
		
		// 将服务器状态设置到 redis 中
		String key = UUID.randomUUID().toString();
		redisDao.setKey(key, gtServerStatus + "", 360);
		
		resStr = gtSdk.getResponseStr();
		GeeInit geeInit = JSON.parseObject(resStr, GeeInit.class);
		geeInit.setStatusKey(key);
		return geeInit;
	}
	
	@GetMapping(value = "/checkLogin")
	public Object checkLogin(@RequestParam(defaultValue = "") String token) {
		String userInfo = userService.checkLogin(token);
		UserDto userDto;
		if (userInfo == null) {
			userDto = new UserDto();
		} else {
			User user = JSON.parseObject(userInfo, User.class);
//			user.setAvatar(Constants.NGINX_URL + user.getAvatar());
			userDto = new UserDto((User) user, "用户已登录", token, 1);
		}
		Response response = new Response(ReturnCode.USER_LOGIN_STATUS_CHECKED, userDto);
		return response;
	}
	
	@PostMapping(value = "/register")
	public Object register(@RequestBody User user) {
		// 注册
		Response response = null;
		boolean flag = false;
		flag = userService.insertNew(user);
		if (flag) {
			response = new Response(ReturnCode.USER_CREATE_SUCCEED);
		} else {
			response = new Response(ReturnCode.USER_REGISTER_ERROR);
		}
		return response;
	}
	
	@PutMapping(value = "/updatePassword/{id}")
	public Object updatePassword(
			@PathVariable Long id,
			@RequestBody PasswordDto passwordDto) {
		System.out.println(passwordDto);
		Response response = null;
		boolean flag = false;
		flag = userService.updatePassword(id, passwordDto.getOldPassword(), passwordDto.getNewPassword());
		if (flag) {
			response = new Response(ReturnCode.USER_PASSWORD_SUCCEED);
		} else {
			response = new Response(ReturnCode.USER_PASSWORD_FAILED);
		}
		return response;
	}
	

}
