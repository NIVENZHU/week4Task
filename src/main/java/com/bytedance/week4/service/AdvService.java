package com.bytedance.week4.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.model.pojo.Advertisement;
import org.springframework.transaction.annotation.Transactional;

public interface AdvService  {
    void insertAdv(Advertisement advertisement);

    IPage<Advertisement> selectAdvByCategory(String category, Integer pageNum, Integer rowNum);

    Advertisement selectAdvById(Long advId);
}
