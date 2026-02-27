package com.example.springsecuritybasedemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo
 * @className: LoginSuccessHandler
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/6/3 0:05
 * @version: v2.0
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "µÇÂ¼³É¹¦");
        result.put("status", 200);
        response.setContentType("application/json;charset=UTF-8");
        String s = new ObjectMapper().writeValueAsString(request);
        response.getWriter().write(s);
    }
}
