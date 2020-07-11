package com.jun.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Link;
import com.jun.service.LinkService;
import com.jun.service.LogService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 阅读日志 前端控制器
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/list")
    public Result LinkList(Integer currentPage){
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage,10);
        IPage PageData = logService.page(page);
        return Result.succ(PageData);
    }

    //逻辑删除
}
