package com.bytedance.week4.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.week4.model.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
