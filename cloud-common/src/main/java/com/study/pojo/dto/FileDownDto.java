package com.study.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 文件上传额外参数
 *
 * @Author YL
 * @Create 2024/1/8 22:06
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class FileDownDto {
    /** 文件名称 */
    @Length(max = 100)
    private String fileName;

    /** 文件保存路径 */
    @Length(max = 200)
    private String fileSavePath;
}
