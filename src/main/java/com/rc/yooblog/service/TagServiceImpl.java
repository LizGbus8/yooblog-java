package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.TagDto;
import com.rc.yooblog.entity.Tag;
import com.rc.yooblog.mapper.TagMapper;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements IService<Tag> {

    /**
     * 获取所有的标签
     * @return
     */
    public List<TagDto> getAllTag() {
        //1.查询
        List<Tag> Tags = list();
        //2.类型转化
        return Tags.stream().map(Tag -> {
            TagDto TagDto = new TagDto();
            BeanUtils.copyProperties(Tag,TagDto);
            return TagDto;
        }).collect(Collectors.toList());
    }
}
