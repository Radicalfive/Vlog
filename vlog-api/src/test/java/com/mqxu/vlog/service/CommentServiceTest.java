package com.mqxu.vlog.service;

import com.mqxu.vlog.VlogApiApplication;
import com.mqxu.vlog.model.entity.Comment;
import com.mqxu.vlog.model.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class CommentServiceTest {
    @Resource
    private CommentService commentService;

    @Test
    void selectByArticleId() {
        List<CommentVo> commentVos = commentService.selectByArticleId("1e73910da0e64a44a730a3c43ef6bdda");
        commentVos.forEach(System.out::println);
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("1e73910da0e64a44a730a3c43ef6bdda")
                .userId(1)
                .content("陶然然的评论")
                .createTime(LocalDateTime.now())
                .build();
        List<CommentVo> commentVos = commentService.addComment(comment);
        commentVos.forEach(System.out::println);
    }
}