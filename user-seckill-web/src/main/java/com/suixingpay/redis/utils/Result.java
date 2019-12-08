package com.suixingpay.redis.utils;

import lombok.Data;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 统一API响应结果封装
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public int setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this.code;
    }

}

