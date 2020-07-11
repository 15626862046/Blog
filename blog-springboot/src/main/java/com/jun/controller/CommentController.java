package com.jun.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.common.lang.Result;
import com.jun.entity.Comment;
import com.jun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/index")
    public Result CommentList(Integer currentPage){
        if (currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage,10);
        return Result.succ(commentService.page(page));
    }

    @PostMapping("/save")
    public Result CommentSave(@RequestBody Comment comment){
        boolean b = commentService.saveOrUpdate(comment);
        System.out.println(b);
        return Result.succ(null);
    }

    //逻辑删除
}
