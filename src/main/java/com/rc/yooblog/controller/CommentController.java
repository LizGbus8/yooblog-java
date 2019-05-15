package com.rc.yooblog.controller;

import com.rc.yooblog.common.dto.CommentDto;
import com.rc.yooblog.common.dto.ReplyDto;
import com.rc.yooblog.common.utils.IpUtils;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.CommentsInfoServiceImpl;
import com.rc.yooblog.service.CommentsReplyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：flandre on 2019/4/6 23:15
 * 描述：
 */
@RestController
@Api(value = "评论留言相关API", tags = "评论&留言")
public class CommentController {

    @Autowired
    CommentsInfoServiceImpl commentsInfoService;

    @Autowired
    CommentsReplyServiceImpl commentsReplyService;


    @GetMapping("/comments")
    @ApiOperation(value = "根据评论Id获取评论列表")
    public ResultVO comments(@RequestParam("ownerId") String ownerId, @RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer current, @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        List<CommentDto> commentDtos = commentsInfoService.getComments(ownerId, current, size);
        return ResultVOUtil.success(commentDtos);
    }

    @GetMapping("/talks")
    @ApiOperation(value = "获取留言列表")
    public ResultVO comments(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current, @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        List<CommentDto> commentDtos = commentsInfoService.getTalks(current, size);
        return ResultVOUtil.success(commentDtos);
    }

    @PostMapping("/talk")
    @ApiOperation(value = "添加一条留言")
    public ResultVO talk(@RequestParam(value = "nickName") String nickName, @RequestParam("email") String email, @RequestParam("website") String website, @RequestParam("content") String content, HttpServletRequest request) throws Exception {
        //获取客户端ip
        String remoteIP = IpUtils.getRemoteIP(request);
        CommentDto commentDto = commentsInfoService.addTalk(nickName, email, website, content, remoteIP);
        return ResultVOUtil.success(commentDto);
    }

    @PostMapping("/article/comment")
    @ApiOperation(value = "文章回复")
    public ResultVO articleComment(@ApiParam("评论所属ownerId") @RequestParam(value = "id") String ownerId, @RequestParam(value = "nickName") String nickName, @RequestParam("email") String email, @RequestParam("website") String website, @RequestParam("content") String content, HttpServletRequest request){
        //获取客户端ip
        String remoteIP = IpUtils.getRemoteIP(request);
        CommentDto commentDto = commentsInfoService.addArticleComment(ownerId, nickName, email, website, content, remoteIP);
        return ResultVOUtil.success(commentDto);
    }

    @PostMapping("/reply/comment")
    @ApiOperation(value = "对留言或者评论的回复")
    public ResultVO reply2Comment(@ApiParam("回复的主体Id,即cid") @RequestParam("id") String cid, @RequestParam(value = "nickName") String nickName, @RequestParam("email") String email, @RequestParam("website") String website, @RequestParam("content") String content, HttpServletRequest request) {
        //获取客户端ip
        String remoteIP = IpUtils.getRemoteIP(request);
        ReplyDto replyDto = commentsInfoService.addReply2Comment(cid, nickName, email, website, content, remoteIP);
        return ResultVOUtil.success(replyDto);
    }

    @PostMapping("/reply/reply")
    @ApiOperation(value = "对回复的回复")
    public ResultVO reply2Reply(@ApiParam("子回复Id,即rid") @RequestParam("id") String rid, @RequestParam(value = "nickName") String nickName, @RequestParam("email") String email, @RequestParam("website") String website, @RequestParam("content") String content, HttpServletRequest request) {
        //获取客户端ipr
        String remoteIP = IpUtils.getRemoteIP(request);
        ReplyDto replyDto = commentsReplyService.addReply2Reply(rid, nickName, email, website, content, remoteIP);
        return ResultVOUtil.success(replyDto);
    }

}
