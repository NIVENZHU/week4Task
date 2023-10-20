package com.bytedance.week4.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.common.ApiRestResponse;
import com.bytedance.week4.common.Constant;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.pojo.Content;
import com.bytedance.week4.service.ContentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsController {
    @Resource
    private ContentService contentService;

    /**
     * 1. 新闻列表的获取
     * @param pageNum
     * @param rowNum
     * @return
     */
    @GetMapping("/content")
    public ApiRestResponse selectAllNews(@RequestParam Integer pageNum,
                                         @RequestParam Integer rowNum){
        if(pageNum==null||rowNum==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        IPage<Content> contentPage = contentService.selectAllNews(pageNum,rowNum);
        List<Content> contentList = contentPage.getRecords();
        int count = contentList.size();
        return ApiRestResponse.success(contentList,count);
    }

    /**
     * 2. 返回单个新闻
     * @param newsId
     * @return
     */
    @GetMapping("/content/{id}")
    public ApiRestResponse selectOneNews(@PathVariable("id") Long newsId){
        if(newsId==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        Content content = contentService.selectOneNews(newsId);
        return ApiRestResponse.success(content);
    }

    /**
     * 3.添加新闻
     * @param content
     * @return
     */
    @PostMapping("/content/add")
    public ApiRestResponse insertOneNews(@Valid @RequestBody Content content){
        contentService.insertOneNews(content);
        return ApiRestResponse.success();
    }
    /**
     * 4. 修改新闻
     */
    @PutMapping("/content/update")
    public ApiRestResponse updateNews(@Valid @RequestBody Content newContent){
        contentService.updateNews(newContent);
        return ApiRestResponse.success();
    }

}
