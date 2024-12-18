package com.study.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * feign请求参数
 *
 * @Author YL
 * @Create 2024/1/4 20:44
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@ToString
public class UserInfoDto {
    private Long userId;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
