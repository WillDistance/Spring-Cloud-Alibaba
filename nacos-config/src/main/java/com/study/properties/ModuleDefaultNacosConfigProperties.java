package com.study.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 读取模块在nacos的默认配置文件
 * 默认读取的文件名称构成为：${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
 *
 * @Author YL
 * @Create 2024/1/4 21:42
 * @Version 1.0
 */
@Data
@ToString
@Component
@RefreshScope //加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
public class ModuleDefaultNacosConfigProperties {
    @Value("${module.config.moduleName:nacos-config}")
    private String moduleName;

    @Value("${module.config.version:v1.0}")
    private String version;
}
