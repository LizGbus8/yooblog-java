package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.entity.Record;
import com.rc.yooblog.mapper.RecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
