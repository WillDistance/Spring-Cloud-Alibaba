package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用nacos作为配置中心demo
 *
 * @Author YL
 * @Create 2024/1/4 21:22
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApp.class, args);
    }
}
