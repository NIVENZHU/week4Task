package com.bytedance.week4.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.common.ApiRestResponse;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.pojo.Comment;
import com.bytedance.week4.model.pojo.Content;
import com.bytedance.week4.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 5. 获取评论列表
     * @param pageNum
     * @param rowNum
     * @return
     */
    @GetMapping("/comment")
    public ApiRestResponse selectAllComment(@RequestParam Integer pageNum,
                                            @RequestParam Integer rowNum){
        if(pageNum==null||rowNum==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        IPage<Comment> commentPage = commentService.selectAllComment(pageNum,rowNum);
        List<Comment> commentList = commentPage.getRecords();
        int count = commentList.size();
        return ApiRestResponse.success(commentList,count);
    }

    /**
     * 6. 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/comment/add")
    public ApiRestResponse insertComment(@Valid @RequestBody Comment comment){
        commentService.insertComment(comment);
        return ApiRestResponse.success();
    }

    /**
     * 7. 删除评论
     * @param commentId
     * @return
     */
    @DeleteMapping("/comment/delete")
    public ApiRestResponse deleteComment(@RequestParam Long commentId){
        commentService.deleteComment(commentId);
        return ApiRestResponse.success();
    }


}
