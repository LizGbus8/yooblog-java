package com.rc.yooblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 文章 
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@Data
@Accessors(chain = true)
public class Tool{

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "tool_id", type = IdType.AUTO)
    private Integer toolId;

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
     * 公开 0隐私 1公开
     */
    private Integer pub;

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

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
