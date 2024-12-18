package com.study.controller;

import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import com.study.service.PostRequestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * post请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/postFeign")
public class PostFeignController {

    @Autowired
    private PostRequestFeignService postRequestFeignService;

    @PostMapping(value = "/postPathParam/{paramId}")
    public CommonResult<FeignResultVo> postPathParam(@PathVariable("paramId") Long paramId) {
        return postRequestFeignService.postPathParam(paramId);
    }

    @PostMapping(value = "/postUrlParam")
    public CommonResult<FeignResultVo> postUrlParam(@RequestParam("paramId") Long paramId,
                                                    @RequestParam("paramValue") String paramValue,
                                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("date") Date date) {
        return postRequestFeignService.postUrlParam(paramId, paramValue, date);
    }

    @PostMapping(value = "/postPathAndUrlParam/{paramId}")
    public CommonResult<FeignResultVo> postPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue) {
        return postRequestFeignService.postPathAndUrlParam(paramId, paramValue);
    }

    @PostMapping(value = "/postEntityParam")
    public CommonResult<FeignResultVo> postEntityParam(@RequestBody FeignParamDto feignParam) {
        return postRequestFeignService.postEntityParam(feignParam);
    }

    @PostMapping(value = "/postPathAndEntityParam/{paramId}")
    public CommonResult<FeignResultVo> postPathAndEntityParam(@PathVariable("paramId") Long paramId, @RequestBody FeignParamDto feignParam) {
        return postRequestFeignService.postPathAndEntityParam(paramId, feignParam);
    }

    @PostMapping(value = "/postListParam")
    public CommonResult<List<FeignResultVo>> postListParam(@RequestBody List<Long> paramIdList) {
        return postRequestFeignService.postListParam(paramIdList);
    }

    @PostMapping(value = "/postUrlAndEntityParam")
    public CommonResult<FeignResultVo> postUrlAndEntityParam(@RequestParam("paramId") Long paramId, @RequestBody FeignParamDto feignParam) {
        return postRequestFeignService.postUrlAndEntityParam(paramId, feignParam);
    }
}
