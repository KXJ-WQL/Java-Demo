package com.WQL.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.exception
 * @Date 2023/3/15 11:17
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IOException.class})//处理的异常
    public String handleAritgException(){

        return "zdyerror";
    }


}
