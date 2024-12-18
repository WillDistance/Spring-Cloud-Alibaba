package com.study.controller;

import com.study.pojo.dto.UserInfoDto;
import com.study.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    // 127.0.0.1:8080/study/consumer/consumerMethod/1111
    @GetMapping("/consumerMethod/{id}")
    public CommonResult<UserInfoDto> consumerMethod(@PathVariable("id") Long userId) {
        ParameterizedTypeReference<CommonResult<UserInfoDto>> reference = new ParameterizedTypeReference<CommonResult<UserInfoDto>>() {};
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserId(userId).setUserName("yanlei").setBirthday(new Date());
        HttpEntity httpEntity = new HttpEntity(userInfoDto);
        return restTemplate.exchange(serverURL + contextPath + "/provider/providerMethod", HttpMethod.POST, httpEntity, reference).getBody();
    }
}
