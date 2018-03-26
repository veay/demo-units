package com.lee.wechatdemo.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Echos on 2017/6/16.
 */
@Controller
@RequestMapping("auth")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wechat.appId}")
    private String appId;
    @Value("${wechat.appSecret}")
    private String appSecret;

    @Value("${wechat.auth.callback}")
    private String wechatCallbackUrl;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private WeixinProxy proxy;

    @PostConstruct
    public void init(){
        proxy = new WeixinProxy(new WeixinAccount(appId, appSecret), new FileCacheStorager<>());
    }

    @RequestMapping("/wechat_auth")
    public ModelAndView wechatAuth(@RequestParam String redirectUrl, HttpServletResponse response){

        String authUrl = proxy.getOauthApi().getUserAuthorizationURL(String.format(wechatCallbackUrl, redirectUrl), "STATE", "snsapi_userinfo");

        return new ModelAndView(new RedirectView(authUrl));
    }


    /**
     * 微信授权回调
     * @param request
     * @param code
     * @param state
     * @param redirectUrl
     * @return
     */
    @RequestMapping("/wechat_callback")
    public ModelAndView wechatCallback(HttpServletRequest request, HttpServletResponse response, String code, String state, String redirectUrl){

        try {
            User user = getUser(code);
            logger.info("{}", user);

            int expire = 24*60*60;
            Cookie cookie = new Cookie("open_id", user.getOpenId());
            cookie.setMaxAge(expire);
            cookie.setPath("/");
            response.addCookie(cookie);

            request.getSession().setAttribute("user", user);
            redisTemplate.opsForValue().set(user.getOpenId(), JSON.toJSONString(user), expire);
        }catch (Exception e){
            logger.error("", e);
        }

        return new ModelAndView("redirect:" + redirectUrl);
    }

    /**
     * 根据授权code获取用户信息
     * @param code
     * @return
     * @throws WeixinException
     */
    private User getUser(String code) throws WeixinException {

        OauthToken token = proxy.getOauthApi().getAuthorizationToken(code);
        User user = proxy.getOauthApi().getAuthorizationUser(token);

        return user;
    }
}
