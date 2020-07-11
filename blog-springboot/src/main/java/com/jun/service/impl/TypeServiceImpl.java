package com.jun.service.impl;

import com.jun.entity.Type;
import com.jun.mapper.TypeMapper;
import com.jun.service.TypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
