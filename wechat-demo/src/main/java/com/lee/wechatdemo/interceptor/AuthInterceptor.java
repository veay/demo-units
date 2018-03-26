package com.lee.wechatdemo.interceptor;

import com.alibaba.fastjson.JSON;
import com.foxinmy.weixin4j.mp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jack
 * @since 2018/2/9
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession(true);

        if(null != session.getAttribute("user")){

            return true;
        }else {

            //cookie
            Cookie[] cookies = httpServletRequest.getCookies();
            if(null != cookies){

                for (Cookie cookie : cookies){

                    if("open_id".equals(cookie.getName())){

                        String openId = cookie.getValue();
                        String userJson = redisTemplate.opsForValue().get(openId);

                        if(!StringUtils.isEmpty(userJson)){

                            session.setAttribute("user", JSON.parseObject(userJson, User.class));
                            return true;
                        }
                    }
                }
            }
        }

        //跳转到授权页
        String redirectUrl = httpServletRequest.getRequestURL().toString();
//        String redirectUrl = URLEncoder.encode(httpServletRequest.getRequestURL().toString(), "UTF-8");
        httpServletResponse.sendRedirect("/auth/wechat_auth?redirectUrl=" + redirectUrl);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
