package com.mybestcoding.mango.backup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.mybestcoding.mango"})
public class MangoBackupApplication implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(MangoBackupApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("http://localhost:" + port + "/swagger-ui.html");
    }
}
