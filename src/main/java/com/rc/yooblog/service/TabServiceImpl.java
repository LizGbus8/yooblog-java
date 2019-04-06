package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.TabDto;
import com.rc.yooblog.entity.Tab;
import com.rc.yooblog.mapper.TabMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 标签 文章标签 服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
public class TabServiceImpl extends ServiceImpl<TabMapper, Tab> implements IService<Tab> {

    public List<TabDto> getAllTab() {
        //1.查询
        List<Tab> tabs = list();
        //2.类型转化
        return tabs.stream().map(tab -> {
            TabDto tabDto = new TabDto();
            BeanUtils.copyProperties(tab,tabDto);
            return tabDto;
        }).collect(Collectors.toList());
    }
}
