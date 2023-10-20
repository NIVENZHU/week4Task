package com.bytedance.week4.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.model.pojo.Content;

import org.springframework.transaction.annotation.Transactional;

/**
 * 新闻模块service方法集
 */
public interface ContentService {

    IPage selectAllNews(Integer pageNum, Integer rowNum);

    Content selectOneNews(Long newsId);

    void insertOneNews(Content content);

    void updateNews(Content newContent);
}
