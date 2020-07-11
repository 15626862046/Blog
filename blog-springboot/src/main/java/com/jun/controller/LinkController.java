package com.jun.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Article;
import com.jun.entity.Link;
import com.jun.service.ArticleService;
import com.jun.service.LinkService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 友链 前端控制器
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @GetMapping("/links")
    public Result tags(){
        return Result.succ(linkService.list());
    }
    @GetMapping("/list")
    public Result LinkList(Integer currentPage){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage,10);
        IPage PageData = linkService.page(page);
        //eq("publish",1)
        return Result.succ(PageData);
    }
    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Link link){
        System.out.println(link.toString());
        linkService.saveOrUpdate(link);
        return Result.succ(null);
    }
}
