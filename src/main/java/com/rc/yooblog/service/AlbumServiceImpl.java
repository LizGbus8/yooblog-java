package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.entity.Album;
import com.rc.yooblog.mapper.AlbumMapper;
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
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements IService<Album> {

}
