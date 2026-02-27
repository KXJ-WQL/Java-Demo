package com.example.springbootvalidator.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @projectName: springboot-validator
 * @package: com.example.springbootvalidator.exception
 * @className: validationException
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/13 1:57
 * @version: v1.0
 */
@RestControllerAdvice
public class validationException {

    @ExceptionHandler(BindException.class)
    public String handlerEx(BindException e){
        //获取所有效验错误信息
        List<FieldError> fieldErrors = e.getFieldErrors();
        //信息异常字符串
        StringBuilder stringBuilder = new StringBuilder("效验异常信息：");
        for(FieldError fe: fieldErrors){
            //拼接异常信息
            stringBuilder.append("效验错误属性：")
                    .append(fe.getField())
                    .append("\n效验不通过原因：")
                    .append(fe.getDefaultMessage())
                    .append(";");
        }
        return stringBuilder.toString();
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> handlerEx(ConstraintViolationException e){
        //获取所有效验错误信息
        Set<ConstraintViolation<?>> fieldErrors = e.getConstraintViolations();
        List<String> collect = fieldErrors.stream()
                .map(v -> "属性-" + v.getPropertyPath() + "<->属性值-" + v.getInvalidValue() + "<->效验不通过的信息: " + v.getMessage())
                .collect(Collectors.toList());
        return collect;
    }
}
