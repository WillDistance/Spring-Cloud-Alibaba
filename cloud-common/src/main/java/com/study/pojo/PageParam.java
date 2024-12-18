package com.study.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页参数
 *
 * @Author YL
 * @Create 2024/1/9 23:34
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class PageParam {
    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
