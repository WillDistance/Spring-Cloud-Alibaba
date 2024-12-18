package com.study.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import feign.Feign;
import feign.codec.EncodeException;
import feign.querymap.FieldQueryMapEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

/**
 * feign客户端配置
 *
 * @Author YL
 * @Create 2024/1/9 23:08
 * @Version 1.0
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder().queryMapEncoder(new DateToStringEncoder());
    }

    public static class DateToStringEncoder extends FieldQueryMapEncoder {
        @Override
        public Map<String, Object> encode(Object object) throws EncodeException {
            Map<String, Object> encode = super.encode(object);
            for (Map.Entry<String, Object> entry : encode.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Date) {
                    encode.put(entry.getKey(), DateUtil.format((Date) value, DatePattern.NORM_DATETIME_PATTERN));
                }
            }
            return encode;
        }
    }
}
