package com.example.springsecuritybasedemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.config
 * @className: CorsConfig
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/6/22 20:08
 * @version: v2.0
 */
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")//路径
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)//是否允许携带Cookie
                .maxAge(360);//设置有效期，表示一个域外请求通过在有效期内都可以直接访问不需要调用该方法进行效验，以秒为单位

    }
}