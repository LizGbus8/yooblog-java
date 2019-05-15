package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.common.dto.AlbumDto;
import com.rc.yooblog.entity.Album;
import com.rc.yooblog.entity.Picture;
import com.rc.yooblog.mapper.AlbumMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements IService<Album> {

    @Autowired
    PictureServiceImpl pictureService;

    /**
     * 获取相册列表
     *
     * @param current
     * @param size
     * @return
     */
    public List<AlbumDto> getAlbums(Integer current, Integer size) {
        //1.拼接相册查询条件
        QueryWrapper<Album> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pub", 1);
        queryWrapper.orderByDesc("created_time");
        Page<Album> page = new Page<>(current, size);
        //2.执行查询
        IPage<Album> favoritesIPage = page(page, queryWrapper);
        //3.获取albId集合
        List<Integer> albIds = favoritesIPage.getRecords().stream().map(Album::getAlbId).collect(Collectors.toList());
        //4.批量查询图片
        QueryWrapper<Picture> pictureQueryWrapper = new QueryWrapper<>();
        pictureQueryWrapper.in("alb_id", albIds);
        List<Picture> pictures = pictureService.list(pictureQueryWrapper);
        //5.填充DTO
        IPage<AlbumDto> albumDtoIPage = favoritesIPage.convert(album -> {
            //相同属性
            AlbumDto albumDto = new AlbumDto();
            BeanUtils.copyProperties(album, albumDto);
            //填充图片
            List<Picture> pics = pictures.stream().filter(picture -> picture.getAlbId().equals(album.getAlbId())).collect(Collectors.toList());
            albumDto.setPictures(pics);
            return albumDto;
        });

        return albumDtoIPage.getRecords();
    }
}
