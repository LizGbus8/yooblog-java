package com.rc.yooblog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rc.yooblog.common.dto.FavoritesDto;
import com.rc.yooblog.common.dto.UtilsDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.service.FavoritesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "收藏夹", value = "收藏夹API")
public class FavoritesController {

    @Autowired
    FavoritesServiceImpl favoritesService;

    @GetMapping("/favorites")
    @ApiOperation(value = "获取收藏列表")
    public ResultVO articles(@RequestParam("currentPage") Integer current, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        IPage<FavoritesDto> favoritesDtoIPage;

        favoritesDtoIPage = favoritesService.getFavorites(current, size);

        return ResultVOUtil.success(favoritesDtoIPage);
    }
}

