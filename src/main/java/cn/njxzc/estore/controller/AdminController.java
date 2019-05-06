package cn.njxzc.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.njxzc.estore.dto.UserDto;
import cn.njxzc.estore.entity.User;
import cn.njxzc.estore.service.IUserService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
@Api(tags = {"Admin"})
public class AdminController {
    
    @Autowired
    private IUserService userService;
    
    /**
     * 管理员登录
     * 
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public Object login(@RequestBody User user) {
        UserDto userDto = new UserDto();
        Response response = null;
        userDto = userService.userLogin(user.getUsername(), user.getPassword());
        // 验证用户名密码
        if (null == userDto.getUser()) {
            response = new Response(ReturnCode.ADMIN_LOGIN_FAILED);
        } else {
            String roleType = userService.getRoleType(userDto.getUser().getRoleId());
            if ("ADMIN".equalsIgnoreCase(roleType)) {
                response = new Response(ReturnCode.ADMIN_LOGIN_SUCCEED, userDto);
            } else {
                response = new Response(ReturnCode.ADMIN_AUTH_FAILED);
            }
        }
        return response;
    }

}
