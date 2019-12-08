package com.suixingpay.redis.interceptor;

import com.suixingpay.redis.service.PanicBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 过滤器
 */
@Component
public class SeckillInterceptor implements HandlerInterceptor {

    @Autowired
    private PanicBuyService panicBuyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return panicBuyService.userEnterRedis();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {

    }
}
