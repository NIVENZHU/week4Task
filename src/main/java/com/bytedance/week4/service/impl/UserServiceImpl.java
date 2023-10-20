package com.bytedance.week4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bytedance.week4.exception.bdException;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.dao.UserMapper;
import com.bytedance.week4.model.pojo.User;
import com.bytedance.week4.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     *用户注册
     * @param user
     */
    @Override
    @Transactional
    public void insertUserByOpenId(User user){
        //验证用户是否已注册
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id",user.getOpenId());
        User oldUser = userMapper.selectOne(queryWrapper);
        if(oldUser!=null){
            throw new bdException(bdExceptionEnum.DUPLICATED_ERROR);
        }
        int count = userMapper.insert(user);
        if(count==0){
            throw new bdException(bdExceptionEnum.INSERT_FAILED);
        }
    }

    /**
     * 更新用户信息
     * @param user
     */
    @Override
    @Transactional
    public void updateUser(User user){
        //验证用户是否存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",user.getUserId());
        User oldUser = userMapper.selectOne(queryWrapper);
        if(oldUser==null){
            throw new bdException(bdExceptionEnum.USER_NOT_EXIST);
        }
        int count = userMapper.updateById(user);
        if(count==0){
            throw new bdException(bdExceptionEnum.UPDATE_FAILED);
        }
    }


}
