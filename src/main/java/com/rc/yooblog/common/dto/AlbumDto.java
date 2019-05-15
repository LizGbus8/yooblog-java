package com.rc.yooblog.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rc.yooblog.entity.Picture;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者：flandre on 2019/4/26 14:07
 * 描述：
 */
@Data
public class AlbumDto {

    private Integer albId;

    private String title;

    private String content;

    private List<Picture> pictures;

    private LocalDateTime createdTime;
}
