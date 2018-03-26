package com.lee.wechatdemo.config;

import com.lee.wechatdemo.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jack
 * @since 2018/2/9
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getMyInterceptors(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptors()).addPathPatterns("/activity/**");
                //.excludePathPatterns("/sys_user/login", "/sys_user/error");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);
    }
}
