package com.jun.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Link;
import com.jun.entity.Type;
import com.jun.service.LinkService;
import com.jun.service.TypeService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    public Result LinkList(Integer currentPage){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage,10);
        IPage PageData = typeService.page(page);
        //eq("publish",1)
        return Result.succ(PageData);
    }
    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Type type){
        System.out.println(type.toString());
        typeService.saveOrUpdate(type);
        return Result.succ(null);
    }
}
