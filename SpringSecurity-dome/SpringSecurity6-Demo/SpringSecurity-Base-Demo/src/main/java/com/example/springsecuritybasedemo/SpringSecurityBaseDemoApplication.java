package com.example.springsecuritybasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecurityBaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBaseDemoApplication.class, args);
    }

}
