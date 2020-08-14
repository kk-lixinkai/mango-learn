package com.mybestcoding.mango.comsumer.hystrix;

import com.mybestcoding.mango.comsumer.service.MangoProducerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By lixinkai on 2020/8/8
 */
@Component
public class MangoProducerHystrix implements MangoProducerService {

    @RequestMapping("/hello")
    @Override
    public String hello() {
        return "Sorry, hello service call failed";
    }
}
