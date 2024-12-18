package com.study;

/**
 * 使用RestTemplate进行服务间相互调用
 *
 * @Author YL
 * @Create 2024/1/9 22:56
 * @Version 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class CloudRestTemplateApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudRestTemplateApp.class, args);
    }
}

