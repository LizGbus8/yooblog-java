package com.rc.yooblog.controller;

import com.rc.yooblog.common.dto.TabDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.TabServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作者：flandre on 2019/4/5 15:43
 * 描述：
 */
@RestController
@Api(value = "标签API",tags = "标签")
public class TabCotroller {
    @Autowired
    TabServiceImpl tabService;

    @GetMapping("/tabs")
    @ApiOperation(value = "获取所有的标签", notes = "分类标签")
    public ResultVO tabs() {
        List<TabDto> tabDtos =  tabService.getAllTab();
        return ResultVOUtil.success(tabDtos);
    }
}
