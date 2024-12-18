package com.study.controller;

import com.study.properties.ModuleDefaultNacosConfigProperties;
import com.study.properties.UserConfigProperties;
import com.study.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从nacos读取配置测试接口
 *
 * @Author YL
 * @Create 2024/1/4 21:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/nacosConfig")
public class NacosConfigController {

    @Autowired
    private UserConfigProperties userConfigProperties;
    @Autowired
    private ModuleDefaultNacosConfigProperties moduleDefaultNacosConfigProperties;

    /**
     * 读取自定义配置文件名称中的配置信息
     * http://127.0.0.1:8001/study/nacosConfig/getConfigInfo
     *
     * @return
     */
    @GetMapping("/getConfigInfo")
    public CommonResult<String> getUserConfigInfo() {
        return CommonResult.success(userConfigProperties.toString());
    }

    /**
     * 读取默认配置文件名称中的配置信息
     * http://127.0.0.1:8001/study/nacosConfig/getModuleDefaultConfigInfo
     *
     * @return
     */
    @GetMapping("/getModuleDefaultConfigInfo")
    public CommonResult<String> getModuleDefaultConfigInfo() {
        return CommonResult.success(moduleDefaultNacosConfigProperties.toString());
    }
}
