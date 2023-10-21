package com.ouc.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dqs
 * @description springmvc的异常处理器
 * @dateTime 2021/11/8 9:43
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        e.printStackTrace();

        return new Result(false, "服务器错误，请稍后再试~");
    }
}
