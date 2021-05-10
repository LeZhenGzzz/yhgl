package com.datou.yhgl.service.impl;

import com.datou.yhgl.entity.Customer;
import com.datou.yhgl.mapper.CustomerMapper;
import com.datou.yhgl.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lz
 * @since 2021-05-08
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
