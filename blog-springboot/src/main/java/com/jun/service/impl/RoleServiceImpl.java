package com.jun.service.impl;

import com.jun.entity.Role;
import com.jun.mapper.RoleMapper;
import com.jun.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
