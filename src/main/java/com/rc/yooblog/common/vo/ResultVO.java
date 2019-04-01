package com.rc.yooblog.common.vo;

import lombok.Data;

/**
 * 作者：flandre on 2018/7/22 9:01
 */
@Data
public class ResultVO<T> {

    /**错误码 */
    private Integer code;

    /**提示信息 */
    private String msg = "";

    /**相应具体内容 */
    private T data;
}
