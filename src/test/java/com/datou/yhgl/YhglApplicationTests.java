package com.datou.yhgl;

import com.datou.yhgl.entity.User;
import com.datou.yhgl.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class YhglApplicationTests {
@Autowired
    UserMapper userMapper;


//查询用户
    @Test
    void queryuser(){
        User user = userMapper.selectById(1236295200393973762L);
        System.out.println(user);
        user.setName("大头2");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    //3 修改用户的操作
    @Test
     void testUpdateUser() {
        //update user set name=? where id=?
        User user = new User();
        user.setId(1236295200393973762L);
        user.setName("岳不群demotest");
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    //2 添加用户的操作
    @Test
     void testAddUser() {
        //手动创建user对象
        User user = new User();
        user.setName("岳不群");
        user.setAge(12);
        user.setEmail("yyyy@11.com");

//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    //1 查询所有的用户
    @Test
     void testGetAllUser() {
        List<User> users = userMapper.selectList(null);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }


}
