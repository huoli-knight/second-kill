package com.suixingpay.redis.exception;

import lombok.Data;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 全局异常
 */
@Data
public class GlobalException extends RuntimeException {

    private String msg;
    private int code;

    public GlobalException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

}
