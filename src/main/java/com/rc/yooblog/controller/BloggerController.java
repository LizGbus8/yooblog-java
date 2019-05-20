package com.rc.yooblog.controller;

import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.entity.Blogger;
import com.rc.yooblog.service.BloggerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：flandre on 2019/4/14 14:32
 * 描述：
 */
@RestController
@Api(value = "用户信息", tags = "用户信息")
public class BloggerController {

    @Autowired
    BloggerServiceImpl BloggerService;

    @GetMapping("/blogger")
    @ApiOperation("获取用户信息")
    public ResultVO user(@RequestParam("id") Integer id) {
        Blogger user = BloggerService.getById(id);
        return ResultVOUtil.success(user);
    }
}
