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
public class Album{

    private static final long serialVersionUID = 1L;

    @TableId(value = "alb_id", type = IdType.AUTO)
    private Integer albId;

    private String title;

    private String content;

    /**
     * 公开 0隐私 1公开
     */
    private Integer pub;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
