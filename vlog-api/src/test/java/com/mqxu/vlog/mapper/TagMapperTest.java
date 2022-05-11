package com.mqxu.vlog.mapper;

import com.mqxu.vlog.VlogApiApplication;
import com.mqxu.vlog.model.entity.Tag;
import com.mqxu.vlog.task.TagTask;
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
class TagMapperTest {
    @Resource
    private TagTask tagTask;
    @Resource
    private TagMapper tagMapper;

    @Test
    void batchInsert() throws Exception {
        //线程池核心线程数为6，最大线程数为10。超时时间为5秒
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        Future<List<Tag>> future = executor.submit(tagTask);
        List<Tag> tags = future.get();
        int count = tagMapper.insertTags(tags);
        System.out.println(count);

    }

    @Test
    void selectAll() {
        List<Tag> tags = tagMapper.selectAll();
        tags.forEach(tag -> System.out.println(tag.getTagName() + "," + tag.getTagColor()));
    }
}