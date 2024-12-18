package com.study.controller;

import com.study.pojo.dto.UserInfoDto;
import com.study.result.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    // 127.0.0.1:8080/study/provider/providerMethod  {"userId":42,"userName":"test_5fd3365b87c4","birthday":"2015-08-12 04:21:04"}
    @PostMapping("/providerMethod")
    public CommonResult<UserInfoDto> providerMethod(@RequestBody UserInfoDto userInfoDto) {
        return CommonResult.success(userInfoDto.setBirthday(new Date()));
    }
}
