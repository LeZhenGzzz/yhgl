package com.datou.yhgl.controller;


import com.datou.yhgl.entity.User;
import com.datou.yhgl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author datou
 * @since 2020-03-07
 */
@Controller
@RequestMapping("/yhgl/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/findall")
    public List<User> findall(){
        List<User> list = userService.list(null);
        return list;
    }
    @GetMapping("{pagename}")
    public String topage(@PathVariable("pagename") String pageName){
        return pageName;
    }

}

