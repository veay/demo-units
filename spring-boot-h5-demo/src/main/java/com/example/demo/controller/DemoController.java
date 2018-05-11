package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.foxinmy.weixin4j.cache.FileCacheStorager;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.model.OauthToken;
import com.foxinmy.weixin4j.mp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Echos on 2017/6/16.
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/sessionPut")
    public String sessionPut(HttpServletRequest request){
        request.getSession().setAttribute("name", "Echos");
        return "ok";
    }

    @RequestMapping("/sessionGet")
    public String sessionGet(HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("name");
        return name;
    }
}
