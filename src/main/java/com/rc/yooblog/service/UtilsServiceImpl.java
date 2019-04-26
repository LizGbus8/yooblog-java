package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.common.dto.UtilsDto;
import com.rc.yooblog.entity.Utils;
import com.rc.yooblog.mapper.UtilsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章  服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@Service
public class UtilsServiceImpl extends ServiceImpl<UtilsMapper, Utils> implements IService<Utils> {

    /**
     * 获取工具列表
     * @param current
     * @param size
     * @return
     */
    public IPage<UtilsDto> getUtils(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Utils> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pub",1);
        queryWrapper.orderByDesc("created_time");
        Page<Utils> page = new Page<>(current, size);
        //2.执行查询
        IPage<Utils> utilsIPage = page(page, queryWrapper);
        //3.转换泛型
        return utilsIPage.convert(UtilsServiceImpl::apply);
    }

    private static UtilsDto apply(Utils utils) {
        UtilsDto utilsDto = new UtilsDto();
        BeanUtils.copyProperties(utils, utilsDto);
        return utilsDto;
    }
}
