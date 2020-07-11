package com.jun.service.impl;

import com.jun.entity.Comment;
import com.jun.mapper.CommentMapper;
import com.jun.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
