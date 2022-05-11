package com.mqxu.vlog.service.impl;

import com.mqxu.vlog.mapper.CommentMapper;
import com.mqxu.vlog.model.entity.Comment;
import com.mqxu.vlog.model.vo.CommentVo;
import com.mqxu.vlog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVo> selectByArticleId(String articleId) {
        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public List<CommentVo> addComment(Comment comment) {
        //补充评论时间
        comment.setCreateTime(LocalDateTime.now());
        //插入
        commentMapper.addComment(comment);
        //查出这篇文章最新的评论列表
        return commentMapper.selectByArticleId(comment.getArticleId());
    }
}
