package com.rc.yooblog.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：flandre on 2019/4/6 23:58
 */
@Data
public class ReplyDto{
    /**
     * 回复编号
     */
    private String rId;

    /**
     * 评论编号
     */
    private String commentsId;

    /**
     * 回复者编号
     */
    private String fromId;

    /**
     * 回复者昵称
     */
    private String fromName;

    /**
     * 被评论者昵称
     */
    private String toName;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;
}
