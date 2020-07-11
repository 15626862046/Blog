package com.jun.service.impl;

import com.jun.entity.Tag;
import com.jun.mapper.TagMapper;
import com.jun.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
