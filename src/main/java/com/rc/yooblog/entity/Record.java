package com.rc.yooblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 归档 
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 归档编号
     */
    @TableId(value = "rec_id", type = IdType.AUTO)
    private Integer recId;

    /**
     * 简说
     */
    private String content;

    /**
     * 引用链接
     */
    private String reference;

    /**
     * 引用说明
     */
    private String referenceDesc;

    /**
     * 作者
     */
    private String author;

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
