package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.entity.Tab;
import com.rc.yooblog.mapper.TabMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
