package com.jun.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Link;
import com.jun.entity.Tag;
import com.jun.service.LinkService;
import com.jun.service.TagService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public Result tags(){
        return Result.succ(tagService.list());
    }

    @GetMapping("/list")
    public Result LinkList(Integer currentPage){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage,10);
        IPage PageData = tagService.page(page);
        //eq("publish",1)
        return Result.succ(PageData);
    }
    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Tag tag){
        System.out.println(tag.toString());
        tagService.saveOrUpdate(tag);
        return Result.succ(null);
    }
}
