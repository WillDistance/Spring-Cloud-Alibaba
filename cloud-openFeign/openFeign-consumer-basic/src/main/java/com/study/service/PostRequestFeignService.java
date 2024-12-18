package com.study.service;

import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@FeignClient(value = "openFeign-provider", contextId = "postRequestFeignService", path = "${server.servlet.context-path}")
public interface PostRequestFeignService {
    @PostMapping(value = "/postRequest/postPathParam/{paramId}")
    CommonResult<FeignResultVo> postPathParam(@PathVariable("paramId") Long paramId);

    @PostMapping(value = "/postRequest/postUrlParam")
    CommonResult<FeignResultVo> postUrlParam(@RequestParam("paramId") Long paramId,
                                             @RequestParam("paramValue") String paramValue,
                                             @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date);

    @PostMapping(value = "/postRequest/postPathAndUrlParam/{paramId}")
    CommonResult<FeignResultVo> postPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue);

    @PostMapping(value = "/postRequest/postEntityParam")
    CommonResult<FeignResultVo> postEntityParam(@RequestBody FeignParamDto feignParam);

    @PostMapping(value = "/postRequest/postPathAndEntityParam/{paramId}")
    CommonResult<FeignResultVo> postPathAndEntityParam(@PathVariable("paramId") Long paramId, @RequestBody FeignParamDto feignParam);

    @PostMapping(value = "/postRequest/postListParam")
    CommonResult<List<FeignResultVo>> postListParam(@RequestBody List<Long> paramIdList);

    @PostMapping(value = "/postRequest/postUrlAndEntityParam")
    CommonResult<FeignResultVo> postUrlAndEntityParam(@RequestParam("paramId") Long paramId, @RequestBody FeignParamDto feignParam);
}