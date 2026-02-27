package com.example.springsecuritybasedemo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.controller
 * @className: BankController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/6/22 19:24
 * @version: v2.0
 */
@RestController
@RequestMapping("/bank")
public class BankController {

    @PostMapping("/transfer")
    public String transfer(@RequestParam String to, @RequestParam int amount, HttpServletRequest request) {
        return " 成功转账 $" + amount + " 给 " + to;
    }

}
