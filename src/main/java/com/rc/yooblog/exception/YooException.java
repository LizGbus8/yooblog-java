package com.rc.yooblog.exception;


/**
 * 作者：flandre on 2019/4/13 19:58
 * 描述：
 */
public class YooException extends Exception {
    private Integer code;
    private String message;

    public YooException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public YooException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
