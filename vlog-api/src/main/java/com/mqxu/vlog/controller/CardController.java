package com.mqxu.vlog.controller;

import com.mqxu.vlog.common.ResponseResult;
import com.mqxu.vlog.common.ResultCode;
import com.mqxu.vlog.model.Card;
import com.mqxu.vlog.util.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public List<Card> getCard() {
        return DataUtil.initCards();
    }
}
