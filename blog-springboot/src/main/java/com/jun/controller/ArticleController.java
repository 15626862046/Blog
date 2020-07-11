package com.jun.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Article;
import com.jun.service.ArticleService;
import com.jun.utils.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result ArticleList(Integer currentPage,Integer pageSize){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        if(pageSize == null || pageSize < 1) pageSize = 5;
        Page page = new Page(currentPage,pageSize);
        IPage PageData = articleService.page(page, new QueryWrapper<Article>().orderByDesc("recommend"));
        //eq("publish",1)
        return Result.succ(PageData);
    }

    @GetMapping("/typeList")
    public Result ArticleTypeList(Integer id,Integer currentPage,Integer pageSize){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        if(pageSize == null || pageSize < 1) pageSize = 5;
        Page page = new Page(currentPage,pageSize);
        IPage PageData = articleService.page(page, new QueryWrapper<Article>().eq("type_Id",id));
        //eq("publish",1)
        return Result.succ(PageData);
    }

    @GetMapping("/{id}")
    public Result ArticleById(@PathVariable("id") Integer id){
        Article article = articleService.getById(id);
        Assert.notNull(article, "该博客已删除！");
        return Result.succ(article);
    }
    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Article article){
        System.out.println(article.toString());
        /*
        Article temp = null;
        if(article.getId() != null) {
            temp = articleService.getById(article.getId());
            Assert.isTrue(temp.getUserId().equals(ShiroUtil.getProfile().getId()), "没有权限编辑");
        } else {
            temp = new Article();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreateTime(LocalDateTime.now());
            temp.setPublish(1);
        }
         BeanUtil.copyProperties(article, temp, "id");
        */
        articleService.saveOrUpdate(article);
        return Result.succ(null);
    }
}
