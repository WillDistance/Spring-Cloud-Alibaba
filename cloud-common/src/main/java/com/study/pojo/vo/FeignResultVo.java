package com.study.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.pojo.dto.FeignParamDto;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
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
public class FeignResultVo {
    public static FeignResultVo toResultVo(FeignParamDto feignParamDto) {
        FeignResultVo feignResultVo = new FeignResultVo();
        BeanUtils.copyProperties(feignParamDto, feignResultVo);
        return feignResultVo;
    }

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private Long paramId;

    private String paramValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
