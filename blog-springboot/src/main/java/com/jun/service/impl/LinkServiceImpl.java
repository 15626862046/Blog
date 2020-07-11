package com.jun.service.impl;

import com.jun.entity.Link;
import com.jun.mapper.LinkMapper;
import com.jun.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 友链 服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}
