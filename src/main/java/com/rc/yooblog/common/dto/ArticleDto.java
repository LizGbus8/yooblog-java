package com.rc.yooblog.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：flandre on 2019/4/4 17:22
 * 描述：
 */
@Data
public class ArticleDto {
    /**
     * 编号
     */
    private Integer aId;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private Integer tId;

    /**
     * 展示图
     */
    private String imageUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 阅读数
     */
    private Integer readCount;

    /**
     * 推荐数
     */
    private Integer starCount;

    /**
     * 分享数
     */
    private Integer shareCount;

    /**
     * 评论数
     */
    private Integer replyCount;

    /**
     * 创建人
     */
    private String author;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;
}
