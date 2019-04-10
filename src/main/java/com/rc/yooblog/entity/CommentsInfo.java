package com.rc.yooblog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论主表 评论&留言
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private String cid;

    /**
     * 类型 0to留言 1to文章评论 2to人
     */
    private Integer type;

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
     * 评论者邮箱
     */
    private String email;

    /**
     * 评论者网址
     */
    private String website;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * ip号来源
     */
    private String ip;

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
     * 是否有效 0删除
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
