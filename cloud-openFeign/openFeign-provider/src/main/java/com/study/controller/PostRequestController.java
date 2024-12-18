package com.study.controller;

import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * post请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/postRequest")
public class PostRequestController {
    @PostMapping(value = "/postPathParam/{paramId}")
    public CommonResult<FeignResultVo> postPathParam(@PathVariable("paramId") Long paramId) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue("post:"+ UUID.randomUUID().toString()).setDate(new Date());
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @PostMapping(value = "/postUrlParam")
    public CommonResult<FeignResultVo> postUrlParam(@RequestParam("paramId") Long paramId,
                                                    @RequestParam("paramValue") String paramValue,
                                                    @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue(paramValue).setDate(date);
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @PostMapping(value = "/postPathAndUrlParam/{paramId}")
    public CommonResult<FeignResultVo> postPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue) {
        FeignParamDto feignParamDto = new FeignParamDto().setParamId(paramId).setParamValue(paramValue).setDate(new Date());
        return CommonResult.success(FeignResultVo.toResultVo(feignParamDto));
    }

    @PostMapping(value = "/postEntityParam")
    public CommonResult<FeignResultVo> postEntityParam(@RequestBody FeignParamDto feignParam) {
        return CommonResult.success(FeignResultVo.toResultVo(feignParam));
    }

    @PostMapping(value = "/postPathAndEntityParam/{paramId}")
    public CommonResult<FeignResultVo> postPathAndEntityParam(@PathVariable("paramId") Long paramId, @RequestBody FeignParamDto feignParam) {
        feignParam.setParamId(paramId);
        return CommonResult.success(FeignResultVo.toResultVo(feignParam));
    }

    @PostMapping(value = "/postListParam")
    public CommonResult<List<FeignResultVo>> postListParam(@RequestBody List<Long> paramIdList) {
        List<FeignResultVo> result = new ArrayList<>();
        for (Long paramId : paramIdList) {
            result.add(FeignResultVo.toResultVo(new FeignParamDto().setParamId(paramId).setParamValue(UUID.randomUUID().toString()).setDate(new Date())));
        }
        return CommonResult.success(result);
    }

    @PostMapping(value = "/postUrlAndEntityParam")
    public CommonResult<FeignResultVo> postUrlAndEntityParam(@RequestParam("paramId") Long paramId, @RequestBody FeignParamDto feignParam) {
        feignParam.setParamId(paramId);
        return CommonResult.success(FeignResultVo.toResultVo(feignParam));
    }
}
