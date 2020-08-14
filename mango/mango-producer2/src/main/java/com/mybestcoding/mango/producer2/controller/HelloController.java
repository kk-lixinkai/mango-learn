package com.mybestcoding.mango.producer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By lixinkai on 2020/8/8
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello Manago2 !";
    }
}
