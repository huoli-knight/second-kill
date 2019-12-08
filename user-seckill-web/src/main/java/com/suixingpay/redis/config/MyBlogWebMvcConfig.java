package com.suixingpay.redis.config;

import com.suixingpay.redis.interceptor.SeckillInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 拦截抢购
 */
@Configuration
public class MyBlogWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SeckillInterceptor seckillInterceptor;
    /**

     * 拦截抢购的路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(seckillInterceptor)
                .addPathPatterns("/panic/get");

    }
}
