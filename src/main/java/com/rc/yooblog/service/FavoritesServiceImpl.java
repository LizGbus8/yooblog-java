package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.common.dto.FavoritesDto;
import com.rc.yooblog.entity.Favorites;
import com.rc.yooblog.mapper.FavoritesMapper;
import org.springframework.beans.BeanUtils;
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
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements IService<Favorites> {

    /**
     * 获取收藏
     * @param current
     * @param size
     * @return
     */
    public IPage<FavoritesDto> getFavorites(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("created_time");
        Page<Favorites> page = new Page<>(current, size);
        //2.执行查询
        IPage<Favorites> favoritesIPage = page(page, queryWrapper);
        //3.转换泛型
        return favoritesIPage.convert(FavoritesServiceImpl::apply);
    }

    private static FavoritesDto apply(Favorites favorites) {
        FavoritesDto favoritesDto = new FavoritesDto();
        BeanUtils.copyProperties(favorites, favoritesDto);
        return favoritesDto;
    }
}
