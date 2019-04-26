package com.rc.yooblog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rc.yooblog.common.dto.ArticleDto;
import com.rc.yooblog.common.dto.UtilsDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.UtilsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flandre
 * @since 2019-04-25
 */
@RestController
@Api(tags = "工具",value = "工具API")
public class UtilsController {

    @Autowired
    UtilsServiceImpl utilsService;

    @GetMapping("/utils")
    @ApiOperation(value = "获取工具列表")
    public ResultVO articles(@RequestParam("currentPage") Integer current, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        IPage<UtilsDto> utilsDtoIPage;

        utilsDtoIPage = utilsService.getUtils(current, size);

        return ResultVOUtil.success(utilsDtoIPage);
    }

}

