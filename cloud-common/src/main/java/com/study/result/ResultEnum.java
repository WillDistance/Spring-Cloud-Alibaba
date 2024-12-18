package com.study.result;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultEnum {

    /**
     * ok
     */
    OK("E00000", "ok"),

    /**
     * 用于直接显示提示用户的错误，内容由输入内容决定
     */
    SHOW_MSG_FAIL("E00001", ""),

    /**
     * 系统异常
     */
    FAIL("E99999", "系统异常");


    private final String code;

    private final String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultEnum{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + "} " + super.toString();
    }

}
