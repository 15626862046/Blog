package com.jun.service.impl;

import com.jun.entity.Log;
import com.jun.mapper.LogMapper;
import com.jun.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 阅读日志 服务实现类
 * </p>
 *
 * @author jun
 * @since 2020-06-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
