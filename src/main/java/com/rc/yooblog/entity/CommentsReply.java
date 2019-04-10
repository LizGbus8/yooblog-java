package com.rc.yooblog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论回复表 
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentsReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复编号
     */
    @TableId
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
     * 回复者邮箱
     */
    private String fromEmail;

    /**
     * 回复者网址
     */
    private String fromWebsite;

    /**
     * 被评论者昵称
     */
    private String toName;

    /**
     * 回复内容
     */
    private String content;

    /**
     * ip来源
     */
    private String ip;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否有效 0为删除
     */
    private Integer valid;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
