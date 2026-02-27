package com.example.springsecuritybasedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.controller
 * @className: AuthorizeController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/7/2 22:46
 * @version: v2.0
 */
@RestController
public class AuthorizeController {

    @GetMapping("/admin")
    public String adminAuthorize(){
        return "admin用户权限";
    }

    @GetMapping("/user")
    public String userAuthorize(){
        return "user用户权限";
    }

    @GetMapping("/roleinfo")
    public String roleinfoAuthorize(){
        return "role_info用户权限";
    }
}
