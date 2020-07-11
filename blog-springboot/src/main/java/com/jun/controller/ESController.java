package com.jun.controller;

import com.jun.service.ArticleService;
import com.jun.service.ESService;
import com.jun.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ESController {

    @Autowired
    private ESService esService;


    @GetMapping("/insertES")
    public Boolean findALLToES() throws Exception {
        return esService.findALLToES();
    }

    @GetMapping("/search/{keyword}")
    public List<Map<String,Object>> search(@PathVariable ("keyword")String keyword,
                                           Integer currentPage,
                                           Integer pageSize) throws Exception {
        //searchPageHighlightBuilder(keyword,pageNo,pageSize)
        return esService.searchPageHighlightBuilder(keyword,currentPage,pageSize);
    }

}
