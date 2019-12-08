package com.suixingpay.redis.utils;

import com.suixingpay.redis.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 响应结果生成工具
 */
@Slf4j
public class ResultGenerator {


    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

    /**
     * 返回成功的类（无数据）
     * @return
     */
    public static Result getSuccessResult() {

        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;

    }

    /**
     * 返回成功的类（有数据）
     * @param msg 信息
     * @return
     */
    public static Result getSuccessResult(String msg) {

        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(msg);
        return result;

    }

    /**
     * 返回成功的类（有数据）
     * @param data 数据
     * @return
     */
    public static Result getSuccessResult(Object data) {

        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;

    }

    /**
     * 返回失败的类
     * @param message 错误信息描述
     * @return
     */
    public static Result getFailResult(String message) {

        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(message);
        return result;

    }

    /**
     * 返回没有权限的类
     * @param message 权限描述
     * @return
     */
    public static Result getNoAuthResult(String message) {

        Result result = new Result();
        result.setCode(ResultCode.UNAUTHORIZED);
        result.setMessage(message);
        return result;

    }

    public static void getException(HttpServletResponse response, GlobalException exception) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.print("{ \"code\": " + exception.getCode() + ", \"message\": \"" + exception.getMsg() + "\"}");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


