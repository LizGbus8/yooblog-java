package com.rc.yooblog.controller;

import com.rc.yooblog.common.dto.CommentDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.CommentsInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作者：flandre on 2019/4/6 23:15
 * 描述：
 */
@RestController
@Api(value = "评论相关API", tags = "评论")
public class CommentController {

    @Autowired
    CommentsInfoServiceImpl commentsInfoService;

    @GetMapping("/comments")
    @ApiOperation(value = "根据评论Id获取评论列表")
    public ResultVO comments(@RequestParam("ownerId") String ownerId, @RequestParam("currentPage") Integer current, @RequestParam("size") Integer size){
        List<CommentDto> commentDtos =  commentsInfoService.getComments(ownerId, current, size);
        return ResultVOUtil.success(commentDtos);
    }
}
