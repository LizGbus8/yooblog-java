package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.CommentDto;
import com.rc.yooblog.common.dto.ReplyDto;
import com.rc.yooblog.common.utils.AvatarUtils;
import com.rc.yooblog.common.utils.IpUtils;
import com.rc.yooblog.common.utils.KeyUtil;
import com.rc.yooblog.entity.CommentsInfo;
import com.rc.yooblog.entity.CommentsReply;
import com.rc.yooblog.mapper.CommentsInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 评论主表 评论&留言 服务实现类
 * </p>
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
@Slf4j
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
        //2.执行查询方法
        return query(queryWrapper, current, size);
    }

    /**
     * 获取留言列表
     * @param current
     * @param size
     * @return
     */
    public List<CommentDto> getTalks(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<CommentsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", 0);
        Page<CommentsInfo> page = new Page<>(current, size);
        //2.执行查询
        return query(queryWrapper, current, size);
    }

    private List<CommentDto> query(QueryWrapper<CommentsInfo> queryWrapper, Integer current, Integer size) {
        //1.设置分页
        queryWrapper.eq("valid", 1);
        queryWrapper.orderByDesc("created_time");
        Page<CommentsInfo> page = new Page<>(current, size);
        //2.执行查询
        IPage<CommentsInfo> commentsInfoPage = page(page, queryWrapper);
        //评论条数为空
        if (CollectionUtils.isEmpty(commentsInfoPage.getRecords())) {
            return null;
        }
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

    /**
     * 添加留言
     *
     * @param nickName
     * @param email
     * @param website
     * @param content
     * @param ip
     * @return
     */
    public CommentDto addTalk(String nickName, String email, String website, String content, String ip) throws Exception {
        //1.从查询头像
        String avatar = AvatarUtils.getQQAvatar(email);
        if (avatar == null) {
            avatar = AvatarUtils.getGravatarAvatar(email);
        }
        //2.查询当前楼层
        QueryWrapper<CommentsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", 0);
        queryWrapper.eq("valid", 1);
        //当前楼层
        int currentFloor = count(queryWrapper);
        //3.根据ip查询地址
        String city = IpUtils.getCity(ip);
        //4.获取quote诗文
        //TODO
        //5.保存数据库
        CommentsInfo commentsInfo = new CommentsInfo();
        commentsInfo.setCId(KeyUtil.getKey())
                .setType(0)
                .setFromId(KeyUtil.getKey())
                .setFromName(nickName)
                .setEmail(email)
                .setWebsite(website)
                .setContent(content)
                .setFromAvatar(avatar)
                .setIp(ip)
                .setAddress(city)
                .setFloor(currentFloor);
        save(commentsInfo);
        //6.返回添加结果
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(commentsInfo, commentDto);
        commentDto.setCreatedTime(LocalDateTime.now());

        return commentDto;
    }

    /**
     * 回复留言或者评论
     * @param cid
     * @param nickName
     * @param email
     * @param website
     * @param content
     * @param remoteIP
     */
    public void addReply2Talk(String cid, String nickName, String email, String website, String content, String remoteIP) {
        //1.查询回复主体的信息
        CommentsInfo commentsInfo = getById(cid);
        //2.查询地址
        String city = IpUtils.getCity(remoteIP);
        //3.保存数据库
        CommentsReply commentsReply = new CommentsReply();
        commentsReply.setRId(KeyUtil.getKey())
                .setCommentsId(commentsInfo.getCId())
                .setFromId(KeyUtil.getKey())
                .setFromName(nickName)
                .setFromEmail(email)
                .setFromWebsite(website)
                .setToName(commentsInfo.getFromName())
                .setIp(remoteIP)
                .setAddress(city)
                .setRId(KeyUtil.getKey())
                .setContent(content);
    }
}

