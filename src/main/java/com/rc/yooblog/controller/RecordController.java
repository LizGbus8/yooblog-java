package com.rc.yooblog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rc.yooblog.common.dto.RecordDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.RecordServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：flandre on 2019/4/12 10:24
 * 描述：
 */
@RestController
@Api(value = "归档API", tags = "归档")
public class RecordController {

    @Autowired
    RecordServiceImpl recordService;

    @GetMapping("/records")
    @ApiOperation("获取归档列表")
    public ResultVO records(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current, @RequestParam(value = "size", defaultValue = "8", required = false) Integer size){
        IPage<RecordDto> recordDtoIPage = recordService.getRecords(current, size);
        return ResultVOUtil.success(recordDtoIPage);
    }
}
