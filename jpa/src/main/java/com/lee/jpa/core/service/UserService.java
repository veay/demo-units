package com.lee.jpa.core.service;

import com.lee.jpa.core.dao.UserCreateRsp;
import com.lee.jpa.core.dao.UserRep;
import com.lee.jpa.core.entity.User;
import com.lee.jpa.core.entity.UserCreateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author jack
 * @since 2018/3/26
 */
@Service
public class UserService {

    @Autowired
    private UserRep userRep;

    @Autowired
    private UserCreateRsp userCreateRsp;

    public List<User> getAll(){
        return userRep.findAll();
    }

    @Transactional()
    public User add(String username,String password){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRep.save(user);
        UserCreateLog userCreateLog = new UserCreateLog();
        userCreateLog.setCreateTime(new Date());
        userCreateLog.setUserId(user.getId());
        userCreateRsp.save(userCreateLog);

        return user;
    }
}
