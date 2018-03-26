package com.lee.thymeleafdemo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jack
 * @since 2017/11/22
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping("")
    public Object index(String name){
        ModelAndView modelAndView = new ModelAndView("/demo/index");
        if(StringUtils.isEmpty(name) && StringUtils.isBlank(name)){
            name = "guest";
        }
        modelAndView.addObject("name",name);
        return modelAndView;
    }

}
