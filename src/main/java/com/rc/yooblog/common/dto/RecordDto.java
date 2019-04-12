package com.rc.yooblog.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 作者：flandre on 2019/4/12 10:32
 * 描述：
 */
@Data
public class RecordDto {
    /**
     * 归档编号
     */
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
     * 创建时间
     */
    private LocalDateTime createdTime;

}
