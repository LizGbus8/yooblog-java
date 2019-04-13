package com.rc.yooblog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rc.yooblog.common.dto.ArticleDto;
import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import com.rc.yooblog.exception.YooException;
import com.rc.yooblog.service.ArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.rc.yooblog.common.contants.ReqCode.LATELY;


/**
 * 作者：flandre on 2019/4/4 17:15
 * 描述：
 */
@RestController
@Api(value = "文章的API", tags = "文章")
@Slf4j
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/articles")
    @ApiOperation(value = "获取文章列表")
    public ResultVO articles(@ApiParam(value = "标签ID,注：其中777，888，999，为特殊标识，用于获取最新、热门等") @RequestParam("tId") Integer tId, @RequestParam("currentPage") Integer current, @RequestParam("size") Integer size) {
        IPage<ArticleDto> articleDtoIPage;

        if (tId.equals(LATELY)) {
            //获取最新发布
            articleDtoIPage = articleService.getLately(current, size);
        }else {
            articleDtoIPage = articleService.getArticlesByTabId(tId, current, size);
        }

        return ResultVOUtil.success(articleDtoIPage);
    }

    @GetMapping("/article/{aId}")
    @ApiOperation(value = "获取文章详情")
    public ResultVO article(@PathVariable("aId") String aId) throws YooException {
        ArticleDto articleDto = articleService.getArticle(aId);
        return ResultVOUtil.success(articleDto);
    }
}
