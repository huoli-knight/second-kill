package com.suixingpay.redis.utils;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {

    SUCCESS(200), //成功
    FAIL(400), //失败
    UNAUTHORIZED(401), //未认证（签名错误）
    NOT_FOUND(404), //接口不存在
    RESUBMIT(66), //重复提交
    OUT_OF_STOCK(77), //库存不足
    OUT_OF_TIME(88), //超时
    NOT_START(99), //未开始
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    public int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}


