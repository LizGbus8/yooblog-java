package com.rc.yooblog.controller;

import com.rc.yooblog.common.dto.TagDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.TagServiceImpl;
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
public class TagController {
    @Autowired
    TagServiceImpl TagService;

    @GetMapping("/tags")
    @ApiOperation(value = "获取所有的标签", notes = "分类标签")
    public ResultVO Tags() {
        List<TagDto> TagDtos =  TagService.getAllTag();
        return ResultVOUtil.success(TagDtos);
    }
}
