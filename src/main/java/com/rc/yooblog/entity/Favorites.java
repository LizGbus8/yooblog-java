package com.rc.yooblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@Data
@Accessors(chain = true)
public class Favorites{

    private static final long serialVersionUID = 1L;

    /**
     * 收藏编号
     */
    @TableId(value = "fav_id", type = IdType.AUTO)
    private Integer favId;

    /**
     * 收藏内容
     */
    private String content;

    /**
     * 收藏链接
     */
    private String link;

    /**
     * 标签
     */
    private String tag;

    private LocalDateTime createdTime;

    private LocalDateTime updateTime;


}
