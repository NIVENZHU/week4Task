package com.bytedance.week4.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.week4.model.pojo.Content;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentMapper extends BaseMapper<Content> {
}
