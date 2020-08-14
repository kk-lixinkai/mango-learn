package com.mybestcoding.mango.comsumer.service;

import com.mybestcoding.mango.comsumer.hystrix.MangoProducerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By lixinkai on 2020/8/8
 */
@FeignClient(name = "mango-producer", fallback = MangoProducerHystrix.class)
public interface MangoProducerService {

    @RequestMapping("/hello")
    public String hello();
}
