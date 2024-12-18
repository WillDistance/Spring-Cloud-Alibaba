package com.study.result;

import lombok.Data;


@Data
public class CommonResult<T> {
    private String code;

    private String message;

    private T data;

    private CommonResult() {
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> serverResponseEntity = new CommonResult<>();
        serverResponseEntity.setData(data);
        serverResponseEntity.setCode(ResultEnum.OK.getCode());
        serverResponseEntity.setMessage(ResultEnum.OK.getMsg());
        return serverResponseEntity;
    }

    public static <T> CommonResult<T> success() {
        CommonResult<T> serverResponseEntity = new CommonResult<>();
        serverResponseEntity.setCode(ResultEnum.OK.getCode());
        serverResponseEntity.setMessage(ResultEnum.OK.getMsg());
        return serverResponseEntity;
    }

    public static <T> CommonResult<T> failMsg(String msg) {
        CommonResult<T> serverResponseEntity = new CommonResult<>();
        serverResponseEntity.setMessage(msg);
        serverResponseEntity.setCode(ResultEnum.SHOW_MSG_FAIL.getCode());
        return serverResponseEntity;
    }

    public static <T> CommonResult<T> fail(ResultEnum ResultEnum) {
        CommonResult<T> serverResponseEntity = new CommonResult<>();
        serverResponseEntity.setMessage(ResultEnum.getMsg());
        serverResponseEntity.setCode(ResultEnum.getCode());
        return serverResponseEntity;
    }

    public static <T> CommonResult<T> fail(ResultEnum ResultEnum, T data) {
        CommonResult<T> serverResponseEntity = new CommonResult<>();
        serverResponseEntity.setMessage(ResultEnum.getMsg());
        serverResponseEntity.setCode(ResultEnum.getCode());
        serverResponseEntity.setData(data);
        return serverResponseEntity;
    }
}
