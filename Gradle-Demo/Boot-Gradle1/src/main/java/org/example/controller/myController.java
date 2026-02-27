package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: Boot-Gradle1
 * @package: org.example.controller
 * @className: myController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/1 17:05
 * @version: v2.0
 */
@RestController
public class myController {

    @GetMapping("/helloGradle")
    public String start(){
        return "Gradle构建Springboot项目";
    }

}
