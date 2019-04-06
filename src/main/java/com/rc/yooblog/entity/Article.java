package com.rc.yooblog.entity;


import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章 
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "a_id", type = IdType.AUTO)
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
     * 公开 0隐私 1公开
     */
    private Integer pub = 1;

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
