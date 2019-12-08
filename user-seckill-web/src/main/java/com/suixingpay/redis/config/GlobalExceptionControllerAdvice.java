package com.suixingpay.redis.config;

import com.suixingpay.redis.exception.GlobalException;
import com.suixingpay.redis.utils.ResultGenerator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 捕获全局异常
 */
@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    /**
     * 捕获全局异常
     * @param exception 异常
     * @param response
     */
    @ExceptionHandler(value = GlobalException.class)
    public void handleServiceException(GlobalException exception, HttpServletResponse response) {

        ResultGenerator.getException(response, exception);

    }

}
