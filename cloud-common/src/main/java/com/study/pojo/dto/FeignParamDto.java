package com.study.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.pojo.PageParam;
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
public class FeignParamDto extends PageParam {
    private Long paramId;

    private String paramValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
