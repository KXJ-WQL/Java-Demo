package com.example.springsecuritybasedemo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.controller
 * @className: loginController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/5/25 13:27
 * @version: v2.0
 */
@RestController
public class loginController {

    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @GetMapping("/tests")
    public String tests(){
        return "登录测试";
    }

    @GetMapping("/error")
    public String error(){
        return "登录失败";
    }

}
