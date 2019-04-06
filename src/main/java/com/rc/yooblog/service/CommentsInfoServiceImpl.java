package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.CommentDto;
import com.rc.yooblog.common.dto.ReplyDto;
import com.rc.yooblog.entity.CommentsInfo;
import com.rc.yooblog.entity.CommentsReply;
import com.rc.yooblog.mapper.CommentsInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.sun.tools.jdi.Packet.Reply;

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

    @Autowired
    CommentsReplyServiceImpl commentsReplyService;

    /**
     * 获取评论列表
     * @param ownerId 被评论对象Id
     * @param current
     * @param size
     * @return
     */
    public List<CommentDto> getComments(String ownerId, Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<CommentsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("owner_id", ownerId);
        queryWrapper.eq("valid", 1);
        queryWrapper.orderByDesc("created_time");
        Page<CommentsInfo> page = new Page<>(current, size);
        //2.执行查询
        IPage<CommentsInfo> commentsInfoPage = page(page, queryWrapper);
        //3.获取cId的集合
        List<String> cIds = commentsInfoPage.getRecords().stream().map(CommentsInfo::getCId).collect(Collectors.toList());
        //4.批量查询回复
        QueryWrapper<CommentsReply> replyQueryWrapper = new QueryWrapper<>();
        replyQueryWrapper.in("comments_id",cIds);
        replyQueryWrapper.eq("valid", 1);
        replyQueryWrapper.orderByAsc("created_time");
        List<CommentsReply> commentsReplies = commentsReplyService.list(replyQueryWrapper);
        //5.填充Dto
        IPage<CommentDto> commentDtoIPage = commentsInfoPage.convert(commentsInfo -> {
            CommentDto commentDto = new CommentDto();
            BeanUtils.copyProperties(commentsInfo, commentDto);
            List<ReplyDto> replyDtos = commentsReplies.stream()
                    //过滤出该cId的回复
                    .filter(e -> e.getCommentsId().equals(commentDto.getCId()))
                    //转化为Dto类型
                    .map((e) -> {
                        ReplyDto replyDto = new ReplyDto();
                        BeanUtils.copyProperties(e, replyDto);
                        return replyDto;
                    })
                    .collect(Collectors.toList());
            commentDto.setReplies(replyDtos);
            return commentDto;
        });

        return commentDtoIPage.getRecords();
    }

}
