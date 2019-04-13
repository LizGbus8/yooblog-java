package com.rc.yooblog.exception;

import lombok.Getter;

@Getter
public enum ResultEnum {
    ARTICLE_NOT_EXIST(1,"文章不存在"),
    USER_PASSWORD_ERROR(2,"用户密码错误"),
    USER_NOT_LOGIN(3,"用户未登录"),
    CODE_ERROR(4,"请求类型错误"),
    VERIFY_NUM_NOT_EXIST(5,"验证码不存在"),
    POST_NOT_EXIST(5,"帖子不存在"),
    USER_NOT_RELEASE(6,"用户未发布"),
    NOT_COLLECT(7,"用户未收藏"),
    NOT_HISTORY(8,"用户没有浏览历史"),
    SAVE_FAIL(9,"保存失败")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
