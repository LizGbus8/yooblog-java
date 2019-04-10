package com.rc.yooblog.common.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者：flandre on 2019/4/6 23:06
 */
@Data
public class CommentDto {
    /**
     * 编号
     */
    private String cid;

    /**
     * 被评论者编号
     */
    private String ownerId;

    /**
     * 评论者编号
     */
    private String fromId;

    /**
     * 评论者昵称
     */
    private String fromName;

    /**
     * 评论者头像
     */
    private String fromAvatar;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * ip号所属地
     */
    private String address;

    /**
     * 留言标题诗文引用
     */
    private String quoteTitle;

    /**
     * 留言标题诗文引用
     */
    private String quoteContent;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 回复列表
     */
    private List<ReplyDto>  replies;
}
