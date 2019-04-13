package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.RecordDto;
import com.rc.yooblog.entity.Record;
import com.rc.yooblog.mapper.RecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 归档  服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IService<Record> {

    /**
     * 获取归档列表
     * @param current
     * @param size
     * @return
     */
    public IPage<RecordDto> getRecords(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("valid", 1);
        queryWrapper.orderByDesc("created_time");
        Page<Record> page = new Page<>(current,size);
        //2.执行查询
        IPage<RecordDto> recordDtoIPage = page(page, queryWrapper).convert(RecordServiceImpl::apply);
        //3.返回结果
        return recordDtoIPage;
    }

    private static RecordDto apply(Record record) {
        RecordDto recordDto = new RecordDto();
        BeanUtils.copyProperties(record, recordDto);
        return recordDto;
    }
}
