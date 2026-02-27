package com.example.springsecuritybasedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.controller
 * @className: TemplateController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/6/2 22:16
 * @version: v2.0
 */
@Controller
public class TemplateController {

    @GetMapping("/newLogin")
    public String newLogin(Model model){
        model.addAttribute("name", 12);
        return "login";
    }

}
