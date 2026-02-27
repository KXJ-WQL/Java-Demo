package com.example.bootgradle2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: Boot-Gradle2
 * @package: com.example.bootgradle2.controller
 * @className: startController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/1 17:49
 * @version: v2.0
 */
@RestController
public class startController {
    @GetMapping("/kk")
    public String s(){
     return "Springboot脚手架创建";
    }
}
