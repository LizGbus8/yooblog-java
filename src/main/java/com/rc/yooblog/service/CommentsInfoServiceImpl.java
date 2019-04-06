package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.entity.CommentsInfo;
import com.rc.yooblog.mapper.CommentsInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论主表 评论&留言 服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
public class CommentsInfoServiceImpl extends ServiceImpl<CommentsInfoMapper, CommentsInfo> implements IService<CommentsInfo> {

}
