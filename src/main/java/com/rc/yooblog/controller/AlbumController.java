package com.rc.yooblog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rc.yooblog.common.dto.AlbumDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.AlbumServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author flandre
 * @since 2019-04-25
 */
@RestController
@Api(tags = "相册", value = "相册API")
public class AlbumController {

    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping("/albums")
    @ApiOperation("获取相册列表")
    public ResultVO list(@RequestParam("currentPage") Integer current, @RequestParam(value = "size", defaultValue = "2") Integer size){

        return ResultVOUtil.success(albumService.getAlbums(current, size));
    }
}

