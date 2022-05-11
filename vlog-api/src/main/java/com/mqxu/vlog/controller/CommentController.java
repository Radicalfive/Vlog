package com.mqxu.vlog.controller;

import com.mqxu.vlog.common.ResultCode;
import com.mqxu.vlog.exception.CustomException;
import com.mqxu.vlog.model.entity.Comment;
import com.mqxu.vlog.model.vo.CommentVo;
import com.mqxu.vlog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
@RestController
@RequestMapping(value = "/api/comment")
@Slf4j
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("{articleId}")
    public List<CommentVo> selectByArticleId(@PathVariable String articleId) {
        List<CommentVo> commentVos = commentService.selectByArticleId(articleId);
        log.info(String.valueOf(commentVos));
        //如果查找结果size为0，抛出"数据未找到"的自定义异常
        if (commentVos.size() == 0) {
            throw new CustomException(ResultCode.RESULT_CODE_DATA_NONE.message(), ResultCode.RESULT_CODE_DATA_NONE);
        }
        return commentVos;
    }

    @PostMapping("add")
    public List<CommentVo> addComment(@RequestBody Comment comment) {
        log.info(String.valueOf(comment));
        List<CommentVo> commentVos = commentService.addComment(comment);
        if (commentVos == null) {
            throw new CustomException(ResultCode.DATA_IS_WRONG.message(), ResultCode.DATA_IS_WRONG);
        }
        return commentVos;
    }
}
