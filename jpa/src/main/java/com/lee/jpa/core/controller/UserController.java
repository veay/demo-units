package com.lee.jpa.core.controller;

import com.lee.jpa.core.entity.User;
import com.lee.jpa.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jack
 * @since 2018/3/26
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("add")
    public User add(String username,String password){
        return userService.add(username, password);
    }
}
