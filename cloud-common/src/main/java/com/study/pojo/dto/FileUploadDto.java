package com.study.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传额外参数
 *
 * @Author YL
 * @Create 2024/1/8 22:06
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class FileUploadDto{
    //可以用@FormProperty重命名参数名称，默认是字段名
    /** 文件下载参数 */
    //@FormProperty("fileDownDto")
    private FileDownDto fileDownDto;

    /** 文件下载参数 */
    //@FormProperty("fileDownDtoJson")
    private String fileDownDtoJson;

    /** 文件 */
    //@FormProperty("file")
    private MultipartFile file;
}
