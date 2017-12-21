package com.lee.distributedlock.core.controller;

import com.lee.distributedlock.core.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @since 2017/12/15
 */
@RestController
@RequestMapping("/")
public class DistributedLockController {

    @Autowired
    DistributedLockService distributedLockService;


    @RequestMapping("")
    public Object getId(){
        long id = distributedLockService.getId();
        return id;
    }
}
