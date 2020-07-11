package com.jun.service.impl;

import com.jun.entity.User;
import com.jun.mapper.UserMapper;
import com.jun.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
