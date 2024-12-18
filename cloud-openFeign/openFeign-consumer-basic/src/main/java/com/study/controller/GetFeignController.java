package com.study.controller;

import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.dto.UserInfoDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import com.study.service.GetRequestFeignService;
import com.study.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * get请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/getFeign")
public class GetFeignController {
    @Autowired
    private GetRequestFeignService getRequestFeignService;

    @GetMapping(value = "/getPathParam/{paramId}")
    public CommonResult<FeignResultVo> getPathParam(@PathVariable("paramId") Long paramId) {
        return getRequestFeignService.getPathParam(paramId);
    }

    @GetMapping(value = "/getUrlParam")
    public CommonResult<FeignResultVo> getUrlParam(@RequestParam("paramId") Long paramId,
                                                   @RequestParam("paramValue") String paramValue,
                                                   @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return getRequestFeignService.getUrlParam(paramId, paramValue, date);
    }

    @GetMapping(value = "/getPathAndUrlParam/{paramId}")
    public CommonResult<FeignResultVo> getPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue) {
        return getRequestFeignService.getPathAndUrlParam(paramId, paramValue);
    }

    @GetMapping(value = "/getEntityParam")
    public CommonResult<FeignResultVo> getEntityParam(FeignParamDto feignParam) {
        return getRequestFeignService.getEntityParam(feignParam);
    }

    @GetMapping(value = "/getPathAndEntityParam/{paramId}")
    public CommonResult<FeignResultVo> getPathAndEntityParam(@PathVariable("paramId") Long paramId, FeignParamDto feignParam) {
        return getRequestFeignService.getPathAndEntityParam(paramId, feignParam);
    }

    @GetMapping(value = "/getListParam")
    public CommonResult<List<FeignResultVo>> getListParam(@RequestParam("paramIdList") List<Long> paramIdList) {
        return getRequestFeignService.getListParam(paramIdList);
    }

    @GetMapping(value = "/getMapToTwoEntityParam")
    public CommonResult<Map<String, Object>> getMapToTwoEntityParam(UserInfoDto userInfoDto, FeignParamDto feignParam) {
        Map<String, String> result = new HashMap<>();
        //BeanUtil.beanToMap(userInfoDto, result, false, false);
        //BeanUtil.beanToMap(feignParam, result, false, false);
        result.putAll(JacksonUtil.stringToObj(JacksonUtil.toJsonString(userInfoDto), Map.class));
        result.putAll(JacksonUtil.stringToObj(JacksonUtil.toJsonString(feignParam), Map.class));
        return getRequestFeignService.getMapToTwoEntityParam(result);
    }
}
