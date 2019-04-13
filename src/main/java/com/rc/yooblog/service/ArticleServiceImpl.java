package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.ArticleDto;
import com.rc.yooblog.entity.Article;
import com.rc.yooblog.entity.CommentsInfo;
import com.rc.yooblog.exception.YooException;
import com.rc.yooblog.mapper.ArticleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rc.yooblog.common.contants.ReplyType.TO_ARTICLE;
import static com.rc.yooblog.exception.ResultEnum.ARTICLE_NOT_EXIST;

/**
 * 作者：flandre on 2019/4/2 11:23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IService<Article> {

    @Autowired
    CommentsInfoServiceImpl commentsInfoService;

    @Autowired
    TabServiceImpl tabService;

    /**
     * 最近发布
     * @param current 当前页
     * @param size 每页条数
     * @return
     */
    public IPage<ArticleDto> getLately(Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("created_time");
        queryWrapper.eq("pub", 1);
        Page<Article> page = new Page<>(current, size);
        //2.执行查询
        IPage<Article> articleIPage = page(page, queryWrapper);
        //3.转换泛型
        return articleIPage.convert(ArticleServiceImpl::apply);
    }

    private static ArticleDto apply(Article article) {
        ArticleDto articleDto = new ArticleDto();
        BeanUtils.copyProperties(article, articleDto);
        return articleDto;
    }

    /**
     * 根据标签获取文章列表
     * @param tId
     * @return
     */
    public IPage<ArticleDto> getArticlesByTabId(Integer tId, Integer current, Integer size) {
        //1.拼接查询条件
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_id", tId);
        queryWrapper.orderByDesc("created_time");
        queryWrapper.eq("pub", 1);
        //2.执行查询
        Page<Article> page = new Page<>(current,size);
        IPage<Article> articleIPage = page(page, queryWrapper);
        //3.转换泛型
        return articleIPage.convert(ArticleServiceImpl::apply);
    }

    /**
     * 获取文章详情
     * @param aId 文章Id
     * @return
     */
    public ArticleDto getArticle(String aId) throws YooException {
        //1.拼接文章查询条件
        QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
        articleQueryWrapper.eq("a_id", aId);
        articleQueryWrapper.eq("pub", 1);
        //2.执行文章查询
        Article article = baseMapper.selectOne(articleQueryWrapper);
        if (article == null) {
            throw new YooException(ARTICLE_NOT_EXIST);
        }
        //3.拼接评论数查询条件
        QueryWrapper<CommentsInfo> commentsInfoQueryWrapper = new QueryWrapper<>();
        commentsInfoQueryWrapper.eq("owner_id", aId);
        commentsInfoQueryWrapper.eq("type", TO_ARTICLE);
        commentsInfoQueryWrapper.eq("valid", 1);
        //4.执行评论数查询
        int count = commentsInfoService.count(commentsInfoQueryWrapper);
        //5.填充DTO
        ArticleDto articleDto = new ArticleDto();
        BeanUtils.copyProperties(article, articleDto);
        articleDto.setReplyCount(count);

        return articleDto;
    }
}
