package com.mqxu.vlog.mapper;

import com.mqxu.vlog.VlogApiApplication;
import com.mqxu.vlog.model.entity.ArticleTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ArticleTagMapperTest {
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Test
    void insertArticleTags() {
        List<ArticleTag> articleTagList = new ArrayList<>();
        articleTagList.add(ArticleTag.builder().articleId("1").tagName("leecode").build());
        articleTagList.add(ArticleTag.builder().articleId("2").tagName("NLP").build());
        articleTagMapper.insertArticleTags(articleTagList);
    }
}