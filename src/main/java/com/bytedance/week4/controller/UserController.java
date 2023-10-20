package com.bytedance.week4.controller;

import com.bytedance.week4.common.ApiRestResponse;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.pojo.User;
import com.bytedance.week4.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 8.微信登录
     * @param user
     * @return
     */
    @PostMapping("/user/registerByOpenId")
    public ApiRestResponse insertUserByOpenId(@Valid @RequestBody User user){
        if(user.getOpenId()==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        userService.insertUserByOpenId(user);
        return ApiRestResponse.success();
    }

    /**
     * 9. 用户更新个人信息
     * @param user
     * @return
     */
    @PutMapping("/user/update")
    public ApiRestResponse updateUser(@Valid @RequestBody User user){
        userService.updateUser(user);
        return ApiRestResponse.success();
    }

}
