package com.study.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.study.pojo.dto.FileDownDto;
import com.study.result.CommonResult;
import com.study.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 文件上传下载请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/fileRequest")
public class FileRequestController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Value("${file-upload.save-dir}")
    private String fileSaveDir;

    /**
     * 上传文件
     *
     * @param file
     * @param fileName
     * @param fileSavePath
     * @return
     */
    @PostMapping("/uploadFile")
    public CommonResult<Map<String, Object>> uploadFile(@RequestPart(name = "file") MultipartFile file,
                                                        @RequestPart(value = "fileName", required = false) String fileName,
                                                        @RequestPart(value = "fileSavePath", required = false) String fileSavePath) {
        fileName = StringUtils.isBlank(fileName) ? file.getOriginalFilename() : fileName;
        fileSavePath = StringUtils.isBlank(fileSavePath) ? fileSaveDir : fileSavePath;

        // 创建文件夹
        File dir = FileUtil.mkdir(fileSavePath);

        try (InputStream inputStream = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(dir.getPath() + File.separator + fileName)) {
            IoUtil.copy(inputStream, outputStream);
        } catch (Exception e) {
            log.error("FileRequestController.uploadFile error", e);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("fileName", fileName);
        result.put("fileSavePath", fileSavePath);
        return CommonResult.success(result);
    }

    /**
     * 上传文件
     *
     * @param file
     * @param fileDownDto
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFileObj")
    public CommonResult<Map<String, Object>> uploadFileObj(@RequestPart(name = "file") MultipartFile file,
                                                           @RequestPart(value = "fileDownDto", required = false) @Valid FileDownDto fileDownDto,
                                                           @RequestPart(value = "fileDownDtoJson", required = false) @Valid String fileDownDtoJson) {
        fileDownDto = Objects.isNull(fileDownDto) ? JacksonUtil.stringToObj(fileDownDtoJson, FileDownDto.class) : fileDownDto;
        String fileName = StringUtils.isBlank(fileDownDto.getFileName()) ? file.getOriginalFilename() : fileDownDto.getFileName();
        String fileSavePath = StringUtils.isBlank(fileDownDto.getFileSavePath()) ? fileSaveDir : fileDownDto.getFileSavePath();

        // 创建文件夹
        File dir = FileUtil.mkdir(fileSavePath);

        try (InputStream inputStream = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(dir.getPath() + File.separator + fileName)) {
            IoUtil.copy(inputStream, outputStream);
        } catch (Exception e) {
            log.error("FileRequestController.uploadFile error", e);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("fileName", fileName);
        result.put("fileSavePath", fileSavePath);
        return CommonResult.success(result);
    }

    /**
     * 上传文件
     *
     * @param file
     * @param fileDownDtoJson
     * @return
     */
    @PostMapping("/uploadFileJsonStr")
    public CommonResult<Map<String, Object>> uploadFileJsonStr(@RequestPart(name = "file") MultipartFile file,
                                                               @RequestPart(value = "fileDownDtoJson", required = false) String fileDownDtoJson) {
        FileDownDto fileDownDto;
        if (StringUtils.isNotBlank(fileDownDtoJson)) {
            fileDownDto = JacksonUtil.stringToObj(fileDownDtoJson, FileDownDto.class);
        } else {
            fileDownDto = new FileDownDto();
        }
        String fileName = StringUtils.isBlank(fileDownDto.getFileName()) ? file.getOriginalFilename() : fileDownDto.getFileName();
        String fileSavePath = StringUtils.isBlank(fileDownDto.getFileSavePath()) ? fileSaveDir : fileDownDto.getFileSavePath();

        // 创建文件夹
        File dir = FileUtil.mkdir(fileSavePath);

        try (InputStream inputStream = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(dir.getPath() + File.separator + fileName)) {
            IoUtil.copy(inputStream, outputStream);
        } catch (Exception e) {
            log.error("FileRequestController.uploadFile error", e);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("fileName", fileName);
        result.put("fileSavePath", fileSavePath);
        return CommonResult.success(result);
    }

    /**
     * 下载文件
     *
     * @param fileDownDto
     */
    @GetMapping("/download")
    public void download(@Valid FileDownDto fileDownDto) {
        String fileSavePath = StringUtils.isBlank(fileDownDto.getFileSavePath()) ? fileSaveDir : fileDownDto.getFileSavePath();

        File file = new File(FileUtil.getAbsolutePath(fileSavePath) + File.separator + fileDownDto.getFileName());
        if (file.exists() && file.isFile()) {
            try (InputStream in = new FileInputStream(file)) {
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

                //文件下载
                IOUtils.copy(in, response.getOutputStream());
            } catch (Exception e) {
                log.error("下载文件失败：" + e.getMessage());
            }
        }
    }
}
