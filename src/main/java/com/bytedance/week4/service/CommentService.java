package com.bytedance.week4.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.model.pojo.Comment;

public interface CommentService {
    IPage selectAllComment(Integer pageNum, Integer rowNum);

    void insertComment(Comment comment);

    void deleteComment(Long commentId);
}
