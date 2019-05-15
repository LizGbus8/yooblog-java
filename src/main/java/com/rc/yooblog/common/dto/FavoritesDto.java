package com.rc.yooblog.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：flandre on 2019/4/26 13:34
 * 描述：
 */
@Data
public class FavoritesDto {
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

}
