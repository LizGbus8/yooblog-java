package com.rc.yooblog.common.dto;

import lombok.Data;

/**
 * 作者：flandre on 2019/4/5 15:47
 * 描述：
 */
@Data
public class TabDto {

    private Integer tId;

    /**
     * 说明
     */
    private String description;

    /**
     * 所属分类
     */
    private String catId;
}
