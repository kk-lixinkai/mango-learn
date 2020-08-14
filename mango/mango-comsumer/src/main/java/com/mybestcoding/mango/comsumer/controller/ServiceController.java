package com.mybestcoding.mango.comsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By lixinkai on 2020/8/8
 */
@RestController
public class ServiceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     *
     * @return
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("mango-producer");
    }

    /**
     * 从所有服务中选择一个服务(轮询)
     *
     * @return
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("mango-producer").getUri().toString();
    }
}
