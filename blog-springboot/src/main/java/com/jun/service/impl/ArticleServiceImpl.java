package com.jun.service.impl;

import com.jun.entity.Article;
import com.jun.mapper.ArticleMapper;
import com.jun.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
