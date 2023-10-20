package com.bytedance.week4.service;

import com.bytedance.week4.model.pojo.User;

public interface UserService {
    void insertUserByOpenId(User user);

    void updateUser(User user);
}
