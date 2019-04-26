package com.rc.yooblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

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
public class Picture {

    private static final long serialVersionUID = 1L;

    /**
     * 相册图片编号
     */
    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    /**
     * 相册编号
     */
    private Integer albId;

    /**
     * 相片url
     */
    private String pictureUrl;


}
