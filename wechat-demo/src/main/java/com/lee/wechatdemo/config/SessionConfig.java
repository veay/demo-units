package com.lee.wechatdemo.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author jack
 * @since 2018/2/9
 */
//maxInactiveIntervalInSeconds为SpringSession的过期时间（单位：秒）
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {
}
