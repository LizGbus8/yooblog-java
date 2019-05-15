package com.rc.yooblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.ReplyDto;
import com.rc.yooblog.common.utils.IpUtils;
import com.rc.yooblog.common.utils.KeyUtil;
import com.rc.yooblog.entity.CommentsReply;
import com.rc.yooblog.mapper.CommentsReplyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 评论回复表  服务实现类
 *
 * @author flandre
 * @since 2019-04-04
 */
@Service
public class CommentsReplyServiceImpl extends ServiceImpl<CommentsReplyMapper, CommentsReply> implements IService<CommentsReply> {

    /**
     * 回复一条子回复
     * @param rid
     * @param nickName
     * @param email
     * @param website
     * @param content
     * @param remoteIP
     */
    public ReplyDto addReply2Reply(String rid, String nickName, String email, String website, String content, String remoteIP) {
        //1.查询子回复
        CommentsReply reply = getById(rid);
        //2.查询地址
        String city = IpUtils.getCity(remoteIP);
        //3.保存数据库
        CommentsReply commentsReply = new CommentsReply();
        commentsReply.setRId(KeyUtil.getKey())
                .setCommentsId(reply.getCommentsId())
                .setFromId(KeyUtil.getKey())
                .setFromName(nickName)
                .setFromEmail(email)
                .setFromWebsite(website)
                .setToName(reply.getFromName())
                .setIp(remoteIP)
                .setAddress(city)
                .setContent(content);
        save(commentsReply);

        //4.返回插入的数据
        ReplyDto replyDto = new ReplyDto();
        CommentsReply info = getById(commentsReply.getRId());
        BeanUtils.copyProperties(info, replyDto);

        return replyDto;
    }
}
