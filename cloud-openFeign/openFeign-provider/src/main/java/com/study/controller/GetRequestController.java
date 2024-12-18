package com.study.controller;

import cn.hutool.core.bean.BeanUtil;
import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.dto.UserInfoDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * get请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/getRequest")
public class GetRequestController {
    @GetMapping(value = "/getPathParam/{paramId}")
    public CommonResult<FeignResultVo> getPathParam(@PathVariable("paramId") Long paramId) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue("get:" + UUID.randomUUID().toString()).setDate(new Date());
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @GetMapping(value = "/getUrlParam")
    public CommonResult<FeignResultVo> getUrlParam(@RequestParam("paramId") Long paramId,
                                                   @RequestParam("paramValue") String paramValue,
                                                   @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue(paramValue).setDate(date);
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @GetMapping(value = "/getPathAndUrlParam/{paramId}")
    public CommonResult<FeignResultVo> getPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue(paramValue).setDate(new Date());
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @GetMapping(value = "/getEntityParam")
    public CommonResult<FeignResultVo> getEntityParam(FeignParamDto feignParam) {
        return CommonResult.success(FeignResultVo.toResultVo(feignParam));
    }

    @GetMapping(value = "/getPathAndEntityParam/{paramId}")
    public CommonResult<FeignResultVo> getPathAndEntityParam(@PathVariable("paramId") Long paramId, FeignParamDto feignParam) {
        feignParam.setParamId(paramId);
        return CommonResult.success(FeignResultVo.toResultVo(feignParam));
    }

    @GetMapping(value = "/getListParam")
    public CommonResult<List<FeignResultVo>> getListParam(@RequestParam("paramIdList") List<Long> paramIdList) {
        List<FeignResultVo> result = new ArrayList<>();
        for (Long paramId : paramIdList) {
            result.add(FeignResultVo.toResultVo(new FeignParamDto().setParamId(paramId).setParamValue(UUID.randomUUID().toString()).setDate(new Date())));
        }
        return CommonResult.success(result);
    }

    @GetMapping(value = "/getMapToTwoEntityParam")
    public CommonResult<Map<String, Object>> getMapToTwoEntityParam(UserInfoDto userInfoDto, FeignParamDto feignParam) {
        Map<String, Object> result = new HashMap<>();
        BeanUtil.beanToMap(userInfoDto, result, false, false);
        BeanUtil.beanToMap(feignParam, result, false, false);
        return CommonResult.success(result);
    }
}
