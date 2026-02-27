package com.example.springbootvalidator.controller;

import com.example.springbootvalidator.bean.UserInfo;
import com.example.springbootvalidator.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @projectName: springboot-validator
 * @package: com.example.springbootvalidator.controller
 * @className: test
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/13 0:11
 * @version: v1.0
 */
@RestController
@Validated
public class test {

    @GetMapping("/validatorbindingResult")
    public String validatorbindingResult(@Validated UserInfo userInfo, BindingResult bindingResult){
        System.out.println("\n"+bindingResult.getAllErrors());
        return "--ok";
    }
    @GetMapping("/validator")
    public String validation(@Valid UserInfo userInfo){
        return "--ok";
    }

    @GetMapping("/validatorshengming")
    public String validatorshengming(UserInfo userInfo){
        List<String> valid = ValidationUtil.valid(userInfo, Default.class);
        System.out.println(valid.toString());
        return "--ok";
    }
    @GetMapping("/validated")
    public String validated(@NotNull String userInfo){

        return "--ok";
    }
}
