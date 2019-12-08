package com.suixingpay.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 抢购Controller
 */
@RestController
@RequestMapping("/panic")
@Slf4j
public class PanicBuyController {

    @PostMapping("/get")
    public String get(String id) {

        try {
            Thread.sleep(100);
        }catch (Exception e){

        }
        log.warn(id);
        return id;
    }

}
