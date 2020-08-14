package com.mybestcoding.mango.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan({"com.mybestcoding.mango.admin.mapper"})
public class MangoAdminApplication implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("http://localhost:" + port + "/swagger-ui.html");
    }

}
