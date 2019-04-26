package com.rc.yooblog.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：flandre on 2019/4/25 15:33
 * 描述：
 */
@Data
public class UtilsDto {
    /**
     * 编号
     */
    private Integer utId;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String tag;

    /**
     * 附件
     */
    private String fileUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 阅读数
     */
    private Integer readCount;

    /**
     * 分享数
     */
    private Integer shareCount;

    /**
     * 关联文章
     */
    private String relevance;

    /**
     * 创建人
     */
    private String author;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

}
