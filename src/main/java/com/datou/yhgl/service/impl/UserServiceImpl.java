package com.datou.yhgl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datou.yhgl.entity.User;
import com.datou.yhgl.mapper.UserMapper;
import com.datou.yhgl.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author datou
 * @since 2020-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
