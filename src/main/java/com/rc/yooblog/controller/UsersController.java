package com.rc.yooblog.controller;

import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.entity.Users;
import com.rc.yooblog.service.UsersServiceImpl;
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
public class UsersController {

    @Autowired
    UsersServiceImpl usersService;

    @GetMapping("/user")
    @ApiOperation("获取用户信息")
    public ResultVO user(@RequestParam("uid") Integer uid) {
        Users user = usersService.getById(uid);
        return ResultVOUtil.success(user);
    }
}
