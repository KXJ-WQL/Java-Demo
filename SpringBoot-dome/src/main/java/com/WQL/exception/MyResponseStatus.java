package com.WQL.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.exception
 * @Date 2023/3/15 14:12
 * @Version 1.0
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "请联系管理员！")
public class MyResponseStatus extends RuntimeException {

    public MyResponseStatus(){

    }
    public MyResponseStatus(String message){
        super(message);
    }

}
