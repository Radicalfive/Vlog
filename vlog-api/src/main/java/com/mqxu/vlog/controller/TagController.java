package com.mqxu.vlog.controller;

import com.mqxu.vlog.model.entity.Tag;
import com.mqxu.vlog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TagController
 * @author: mqxu
 **/
@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("all")
    public List<Tag> getTags() {
        return tagService.selectAll();
    }
}
