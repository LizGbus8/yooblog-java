package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rc.yooblog.common.dto.ToolDto;
import com.rc.yooblog.entity.Tool;
import com.rc.yooblog.mapper.ToolMapper;
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
public class ToolServiceImpl extends ServiceImpl<ToolMapper, Tool> implements IService<Tool> {

    /**
     * 获取工具列表
     * @param current
     * @param size
     * @return
     */
    public IPage<ToolDto> getTool(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Tool> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pub",1);
        queryWrapper.orderByDesc("created_time");
        Page<Tool> page = new Page<>(current, size);
        //2.执行查询
        IPage<Tool> ToolIPage = page(page, queryWrapper);
        //3.转换泛型
        return ToolIPage.convert(ToolServiceImpl::apply);
    }

    private static ToolDto apply(Tool Tool) {
        ToolDto ToolDto = new ToolDto();
        BeanUtils.copyProperties(Tool, ToolDto);
        return ToolDto;
    }
}
