package com.rc.yooblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rc.yooblog.common.dto.ArticleDto;
import com.rc.yooblog.entity.Article;
import com.rc.yooblog.mapper.ArticleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 作者：flandre on 2019/4/2 11:23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IService<Article> {

    /**
     * 最近发布
     * @param current 当前页
     * @param size 每页条数
     * @return
     */
    @SuppressWarnings("Duplicates")
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
    public IPage<ArticleDto> getArticleByTabId(Integer tId, Integer current, Integer size) {
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
}