package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.entity.Picture;
import com.rc.yooblog.mapper.PictureMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements IService<Picture> {

}
