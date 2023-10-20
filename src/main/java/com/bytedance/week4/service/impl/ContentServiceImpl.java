package com.bytedance.week4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bytedance.week4.exception.bdException;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.dao.ContentMapper;
import com.bytedance.week4.model.pojo.Content;
import com.bytedance.week4.service.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

@Service("ContentService")
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentMapper contentMapper;

    /**
     * 返回所有的新闻
     * @param pageNum
     * @param rowNum
     * @return
     */
    @Override
    public IPage selectAllNews(Integer pageNum, Integer rowNum){
        Page<Content> p = new Page<>(pageNum,rowNum);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage<Content> page = contentMapper.selectPage(p,queryWrapper);
        return page;
    }

    /**
     * 返回单个新闻
     * @param newsId
     * @return
     */
    @Override
    public Content selectOneNews(Long newsId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("news_id",newsId);
        Content content = contentMapper.selectOne(queryWrapper);
        //如果该新闻id不存在，抛出异常
        if(content==null){
            throw new bdException(bdExceptionEnum.NEWS_NOT_EXIST);
        }
        return content;
    }

    /**
     * 添加新闻
     * @param content
     * @return
     */
    @Override
    @Transactional
    public void insertOneNews(Content content){
        content.setCreateTime(new Date());
        int count = contentMapper.insert(content);
        if(count==0){
            throw new bdException(bdExceptionEnum.INSERT_FAILED);
        }
    }

    /**
     * 编辑新闻
     * @param newContent
     */
    @Override
    @Transactional
    public void updateNews(Content newContent){
        int count = contentMapper.updateById(newContent);
        if(count==0){
            throw new bdException(bdExceptionEnum.UPDATE_FAILED);
        }
    }



}
