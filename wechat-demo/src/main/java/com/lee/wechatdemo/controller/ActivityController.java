package com.lee.wechatdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jack
 * @since 2018/2/9
 */
@Controller
@RequestMapping("activity")
public class ActivityController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
