package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * OpenFeign生产者
 *
 * @Author YL
 * @Create 2024/1/7 14:36
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OpenFeignProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignProviderApp.class, args);
    }
}
