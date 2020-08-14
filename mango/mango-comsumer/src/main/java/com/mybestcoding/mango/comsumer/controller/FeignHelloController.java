package com.mybestcoding.mango.comsumer.controller;

import com.mybestcoding.mango.comsumer.service.MangoProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By lixinkai on 2020/8/8
 */
@RestController
public class FeignHelloController {
    @Autowired
    private MangoProducerService mangoProducerService;

    @RequestMapping("/feign/call")
    public String call() {
        // 像调用本地服务一样
        return mangoProducerService.hello();
    }
}
