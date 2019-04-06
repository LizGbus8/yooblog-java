package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.entity.CommentsReply;
import com.rc.yooblog.mapper.CommentsReplyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论回复表  服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
public class CommentsReplyServiceImpl extends ServiceImpl<CommentsReplyMapper, CommentsReply> implements IService<CommentsReply> {

}
