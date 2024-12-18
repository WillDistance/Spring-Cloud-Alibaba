package com.study.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.study.pojo.dto.FileDownDto;
import com.study.pojo.dto.FileUploadDto;
import com.study.result.CommonResult;
import com.study.service.FileRequestFeignService;
import com.study.utils.JacksonUtil;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Collection;
import java.util.Map;

/**
 * 文件上传下载请求接口
 *
 * @Author YL
 * @Create 2024/1/7 15:07
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/fileFeign")
public class FileFeignController {

    @Autowired
    private HttpServletResponse response;
    @Autowired
    private FileRequestFeignService fileRequestFeignService;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public CommonResult<Map<String, Object>> uploadFile(@RequestPart(name = "file") MultipartFile file) {
        FileDownDto fileDownDto = new FileDownDto().setFileName(file.getOriginalFilename()).setFileSavePath("itemDir");
        return fileRequestFeignService.uploadFile(file, fileDownDto);
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadFileObj")
    public CommonResult<Map<String, Object>> uploadFileObj(@RequestPart(name = "file") MultipartFile file) {
        FileUploadDto fileUploadDto = new FileUploadDto();
        fileUploadDto.setFile(file);
        FileDownDto fileDownDto = new FileDownDto();
        fileDownDto.setFileName(file.getOriginalFilename());
        fileDownDto.setFileSavePath("itemDir");
        fileUploadDto.setFileDownDto(fileDownDto);
        fileUploadDto.setFileDownDtoJson(JacksonUtil.toJsonString(fileDownDto));
        return fileRequestFeignService.uploadFileObj(fileUploadDto);
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadFileJsonStr")
    public CommonResult<Map<String, Object>> uploadFileJsonStr(@RequestPart(name = "file") MultipartFile file) {
        FileDownDto fileDownDto = new FileDownDto();
        fileDownDto.setFileName(file.getOriginalFilename());
        fileDownDto.setFileSavePath("itemDir");
        return fileRequestFeignService.uploadFileJsonStr(file, JacksonUtil.toJsonString(fileDownDto));
    }


    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadFileLocal")
    public CommonResult<Map<String, Object>> uploadFileLocal(@RequestPart(name = "file") MultipartFile file) {
        // 将上传的文件保存到本地
        String fileName = file.getOriginalFilename();
        String fileSavePath = FileUtil.getTmpDirPath();
        File dir = FileUtil.mkdir(fileSavePath);
        File savefile = FileUtil.touch(dir.getPath() + File.separator + fileName);
        try (InputStream inputStream = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(savefile)) {
            IoUtil.copy(inputStream, outputStream);
        } catch (Exception e) {
            log.error("FileRequestController.uploadFile error", e);
        }

        // 使用本地文件构造MultipartFile
        MultipartFile multipartFile = this.getMultipartFile(savefile);

        FileDownDto fileDownDto = new FileDownDto().setFileName(file.getOriginalFilename()).setFileSavePath("itemDir");

        // 上传文件
        return fileRequestFeignService.uploadFile(multipartFile, fileDownDto);
    }

    private MultipartFile getMultipartFile(File file) {
        FileItem item = new DiskFileItemFactory().createItem("file", MediaType.MULTIPART_FORM_DATA_VALUE, true, file.getName());
        try (InputStream input = new FileInputStream(file);
             OutputStream os = item.getOutputStream()) {
            // 流转移
            IoUtil.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        return new CommonsMultipartFile(item);
    }

    /**
     * 下载文件
     *
     * @param fileDownDto
     */
    @GetMapping("/download")
    public void download(@Valid FileDownDto fileDownDto) {
        try (OutputStream outputStream = response.getOutputStream(); //因为服务B中没有返回值的，但是这里它需要把文件给保留下来，所以使用Response接收参数
             Response feignResponse = fileRequestFeignService.download(fileDownDto);
             InputStream stream = feignResponse.body().asInputStream()) {

            Map<String, Collection<String>> headers = feignResponse.headers();
            Collection<String> contentTypes = headers.get(HttpHeaders.CONTENT_TYPE);
            Collection<String> contentDispositions = headers.get(HttpHeaders.CONTENT_DISPOSITION);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.addHeader(HttpHeaders.CONTENT_DISPOSITION, CollectionUtils.get(contentDispositions, 0));
            response.addHeader(HttpHeaders.CONTENT_TYPE, CollectionUtils.get(contentTypes, 0));

            //response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            //response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileUploadDto.getFileName(), "UTF-8"));
            IoUtil.copy(stream, outputStream); //调用 IOUtils.copy。将输入流复制到输出流即可,就可以返回到前端了
        } catch (Exception e) {
            log.error("下载文件失败：" + e.getMessage());
        }
    }
}
