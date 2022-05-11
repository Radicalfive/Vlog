package com.mqxu.vlog.service;

import com.github.pagehelper.PageInfo;
import com.mqxu.vlog.VlogApiApplication;
import com.mqxu.vlog.model.entity.Article;
import com.mqxu.vlog.model.vo.ArticleVo;
import com.mqxu.vlog.task.ArticleTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = null;
        try {
            articles = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        articleService.insertArticles(articles);
    }


    @Test
    void selectByPage() {
        PageInfo<ArticleVo> articlePageInfo = articleService.selectByPage(1, 9);
        System.out.println(articlePageInfo.getList().size());
    }

    @Test
    void getRecommend() {
        List<ArticleVo> recommendArticles = articleService.getRecommendArticles();
        recommendArticles.forEach(System.out::println);
    }

    @Test
    void getDetail() {
        ArticleVo detail = articleService.getDetail("090fae3b8aa84adb8af4e92a11773cde");
        System.out.println(detail);
    }
}