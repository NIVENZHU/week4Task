package com.bytedance.week4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bytedance.week4.exception.bdException;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.dao.CommentMapper;
import com.bytedance.week4.model.dao.ContentMapper;
import com.bytedance.week4.model.dao.UserMapper;
import com.bytedance.week4.model.pojo.Comment;
import com.bytedance.week4.model.pojo.Content;
import com.bytedance.week4.model.pojo.User;
import com.bytedance.week4.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ContentMapper contentMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 获取所有评论
     * @param pageNum
     * @param rowNum
     * @return
     */
    @Override
    public IPage selectAllComment(Integer pageNum, Integer rowNum){
        Page<Comment> p = new Page<>(pageNum,rowNum);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage<Content> page = commentMapper.selectPage(p,queryWrapper);
        return page;
    }

    /**
     * 添加评论
     * @param comment
     */
    @Override
    @Transactional
    public void insertComment(Comment comment){
        //验证用户id和新闻id存在
        User user = userMapper.selectById(comment.getUserId());
        Content content = contentMapper.selectById(comment.getNewsId());
        if(user==null){
            throw new bdException(bdExceptionEnum.USER_NOT_EXIST);
        }
        if(content==null){
            throw new bdException(bdExceptionEnum.NEWS_NOT_EXIST);
        }
        comment.setCreateTime(new Date());
        int count = commentMapper.insert(comment);
        if(count==0){
            throw new bdException(bdExceptionEnum.INSERT_FAILED);
        }
    }

    /**
     * 删除评论
     * @param commentId
     */
    @Override
    @Transactional
    public void deleteComment(Long commentId){
        //查看该评论是否存在
        Comment comment = commentMapper.selectById(commentId);
        if(comment==null){
            throw new bdException(bdExceptionEnum.COMMENT_NOT_EXIST);
        }
        int count = commentMapper.deleteById(commentId);
        if(count==0){
            throw new bdException(bdExceptionEnum.DELETE_FAILED);
        }
    }
}
