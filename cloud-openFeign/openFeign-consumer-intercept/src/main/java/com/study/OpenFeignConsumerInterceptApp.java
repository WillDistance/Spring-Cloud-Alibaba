package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * OpenFeign消费者
 * 演示如何使用OpenFeign的拦截器，在调用其他服务接口前后对请求进行处理
 *
 * @Author YL
 * @Create 2024/1/7 14:36
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OpenFeignConsumerInterceptApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumerInterceptApp.class, args);
    }
}
