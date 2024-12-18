package com.study;

import cn.hutool.json.JSONUtil;
import com.study.config.FeignClientConfig;
import com.study.service.GetRequestFeignService;
import com.study.service.PostRequestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * OpenFeign消费者
 * 演示通过OpenFeign调用其他模块接口时的基础使用方式
 *
 * @Author YL
 * @Create 2024/1/7 14:36
 * @Version 1.0
 */
@Slf4j
@EnableFeignClients(defaultConfiguration = FeignClientConfig.class)
@EnableDiscoveryClient
@SpringBootApplication
public class OpenFeignConsumerBasicApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OpenFeignConsumerBasicApp.class, args);
        String[] beanNamesForType = context.getBeanNamesForType(GetRequestFeignService.class);
        log.info("GetRequestFeignService bean name is:" + JSONUtil.toJsonStr(beanNamesForType));
        beanNamesForType = context.getBeanNamesForType(PostRequestFeignService.class);
        log.info("PostRequestFeignService bean name is:" + JSONUtil.toJsonStr(beanNamesForType));

        GetRequestFeignService getRequestFeignService = context.getBean(GetRequestFeignService.class);
        log.info("getRequestFeignService is null:" + (getRequestFeignService == null) + " " + getRequestFeignService.toString());
        PostRequestFeignService postRequestFeignService = context.getBean(PostRequestFeignService.class);
        log.info("postRequestFeignService is null:" + (postRequestFeignService == null) + " " + postRequestFeignService.toString());
    }
}
