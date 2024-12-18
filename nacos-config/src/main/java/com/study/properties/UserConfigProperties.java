package com.study.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 用户信息配置（从nacos读取配置，并支持动态刷新）
 *
 * @Author YL
 * @Create 2024/1/4 21:29
 * @Version 1.0
 */
@Data
@ToString
@Component
@RefreshScope //加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
public class UserConfigProperties {
    @Value("${user.config.userName:系统代码中默认用户姓名}")
    private String userName;

    @Value("${user.config.account:系统代码中默认账户}")
    private String account;
}
