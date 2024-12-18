package com.study.service;

import com.study.pojo.dto.FeignParamDto;
import com.study.pojo.vo.FeignResultVo;
import com.study.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@FeignClient(value = "openFeign-provider", contextId = "getRequestFeignService", path = "${server.servlet.context-path}")
public interface GetRequestFeignService {
    @GetMapping(value = "/getRequest/getPathParam/{paramId}")
    CommonResult<FeignResultVo> getPathParam(@PathVariable("paramId") Long paramId);

    @GetMapping(value = "/getRequest/getUrlParam")
    CommonResult<FeignResultVo> getUrlParam(@RequestParam("paramId") Long paramId,
                                            @RequestParam("paramValue") String paramValue,
                                            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date);

    @GetMapping(value = "/getRequest/getPathAndUrlParam/{paramId}")
    CommonResult<FeignResultVo> getPathAndUrlParam(@PathVariable("paramId") Long paramId, @RequestParam("paramValue") String paramValue);

    @GetMapping(value = "/getRequest/getEntityParam")
    CommonResult<FeignResultVo> getEntityParam(@SpringQueryMap FeignParamDto feignParam);

    @GetMapping(value = "/getRequest/getPathAndEntityParam/{paramId}")
    CommonResult<FeignResultVo> getPathAndEntityParam(@PathVariable("paramId") Long paramId, @SpringQueryMap FeignParamDto feignParam);

    @GetMapping(value = "/getRequest/getListParam")
    CommonResult<List<FeignResultVo>> getListParam(@RequestParam("paramIdList") List<Long> paramIdList);

    // 这里最好只用Map<String, String>作为参数，若使用Map<String, Object>，则会自动将调用Object.toString()转为String。例如在传递Date参数时，就会造成服务提供者无法正确解析
    @GetMapping(value = "/getRequest/getMapToTwoEntityParam")
    CommonResult<Map<String, Object>> getMapToTwoEntityParam(@SpringQueryMap Map<String, String> mapParam);

}