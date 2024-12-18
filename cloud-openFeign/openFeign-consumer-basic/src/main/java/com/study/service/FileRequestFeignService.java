package com.study.service;

import com.study.pojo.dto.FileDownDto;
import com.study.pojo.dto.FileUploadDto;
import com.study.result.CommonResult;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(value = "openFeign-provider", contextId = "fileRequestFeignService", path = "${server.servlet.context-path}")
public interface FileRequestFeignService {
    // 存在的问题，经验证，openfeign在进行文件上传的同时无法直接传递对象参数

    @PostMapping(value = "/fileRequest/uploadFile", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResult<Map<String, Object>> uploadFile(@RequestPart(name = "file") MultipartFile file, @RequestPart("fileDownDto") FileDownDto fileDownDto);

    @PostMapping(value = "/fileRequest/uploadFileObj", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResult<Map<String, Object>> uploadFileObj(FileUploadDto fileUploadDto);

    @PostMapping(value = "/fileRequest/uploadFileJsonStr", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResult<Map<String, Object>> uploadFileJsonStr(@RequestPart(name = "file") MultipartFile file, @RequestPart("fileDownDtoJson") String fileDownDtoJson);

    @GetMapping("/fileRequest/download")
    Response download(@SpringQueryMap FileDownDto fileDownDto);
}