package com.example.springsecuritybasedemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.controller
 * @className: AuthorizeMethodController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/7/6 22:47
 * @version: v2.0
 */
@RestController
public class AuthorizeMethodController {

    // 请求方法前进行权限判断
    @GetMapping("/delteUser")
    @PreAuthorize("hasAuthority('ADMIN')") // 判断是否有ADMIN的角色
    public String deleteUser(){
        return "PreAuthorize()方法授权";
    }

    @GetMapping("/delteUserName")
    @PreAuthorize("#userName.equals('admin')") // 登录的用户名要为admin
    public String updateUser(String userName){
        return "PreAuthorize()方法授权";
    }

    // 请求方法后对返回值进行判断
    @GetMapping("/seleUser")
    @PostAuthorize("returnObject.equals('PostAuthorize')") // 返回值必须要为PostAuthorize
    public String getDocument() {
        return "PostAuthorize";
    }

    // 请求方法前进行参数过滤
    @GetMapping("/filterUser")
    @PreFilter("filterObject % 2 == 0")
    public void filterUser(List<Integer> ids) {
        // 只会接收到偶数
        System.out.println(ids);
    }

    // 请求方法后对返回值进行过滤
    @GetMapping("/findAllDatas")
    @PostFilter("filterObject.equals('wql')")
    public List<String> findAllDatas() {
        return List.of("wql","hym","ff");
    }

    // 角色判断
    @GetMapping("/secured")
    @Secured("USER")
    public String createAdmin() {
        return "拥有角色USER";
    }

}
