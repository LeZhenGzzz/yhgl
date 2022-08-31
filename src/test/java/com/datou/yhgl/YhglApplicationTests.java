package com.datou.yhgl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
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
    @Test
    public void simpleSendTest() {
        // 创建邮件账户对象
        MailAccount account = new MailAccount();
        // 邮件服务器的SMTP地址，可选，默认为smtp.<发件人邮箱后缀>
        account.setHost("smtp.exmail.qq.com");
        // 邮件服务器的SMTP端口，默认是25端口,ssl端口465
        account.setPort(465);
        // 是否需要用户名密码验证
        account.setAuth(true);
        // 发送方，遵循RFC-822标准
        account.setFrom("yuezheng@manchen.cn");
        // 用户名,腾讯企业邮箱必须要设置成你自己使用邮箱的名称，否则会报错，权限认证失败
        account.setUser("yuezheng@manchen.cn");
        // 使用客户端密码(授权码)--需提前在邮箱中配置设置
        account.setPass("992Cim3RsAB6nybQ");
        // 开启ssl安全连接
        account.setSslEnable(true);
        // 参数2是收件邮箱,可以是多个,参数3是主题,参数4是内容,参数5是否是html格式内容标识
        MailUtil.send(account, CollUtil.newArrayList( "qujingyan@manchen.cn","dingwenqing@manchen.cn","642818795@qq.com"), "主题:提桶跑路测试", "邮件来自提桶跑路测试", false);
    }

}
