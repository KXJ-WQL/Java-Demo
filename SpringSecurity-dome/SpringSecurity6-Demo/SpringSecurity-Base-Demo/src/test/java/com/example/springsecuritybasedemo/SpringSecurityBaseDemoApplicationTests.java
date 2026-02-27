package com.example.springsecuritybasedemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.expression.Calendars;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringSecurityBaseDemoApplicationTests {

    @Test
    void createToken() {
        Map map = new HashMap();

        // 日期工具类
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,20); // 在当前时间加上20秒(时间计算)

        String token = JWT.create().withHeader(map) // 设置头部信息
                .withSubject("123") // 设置主体
                .withClaim("sex","1") // 设置自定义公共claim
                .withExpiresAt(instance.getTime()) //设置令牌过期时间
                .sign(Algorithm.HMAC256("!dwqasj2"));//指定算法生成最终签名

        System.out.println(token);
    }

    @Test
    void RequireJWT() {
        // 创建效验对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!dwqasj2"))
                .withSubject("123")
                .build();
        // 进行效验
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJzZXgiOiIxIiwiZXhwIjoxNzQ5MDc0ODIwfQ.ATPY7FoFusZ9YwCHaih9TknciMCcEYKdbkasEeIO0uQ");
            System.out.println(decodedJWT.getSubject());// 获取主体信息
            System.out.println(decodedJWT.getClaims().get("sub").asString()); // 获取指定公共声明信息
            System.out.println("Token验证通过，sub: " + decodedJWT.getSubject());
        } catch (TokenExpiredException e) {
            System.out.println("❌ Token 已过期");

        } catch (SignatureVerificationException e) {
            System.out.println("❌ 签名无效，可能被篡改");

        } catch (AlgorithmMismatchException e) {
            System.out.println("❌ 签名算法不匹配");

        } catch (InvalidClaimException e) {
            System.out.println("❌ Claims 校验失败，例如 sub、iss 等不符合");

        } catch (JWTDecodeException e) {
            System.out.println("❌ 无法解码 Token，格式非法");

        } catch (JWTVerificationException e) {
            System.out.println("❌ Token 验证失败：" + e.getMessage());

        } catch (Exception e) {
            System.out.println("❌ 其他未知错误：" + e.getMessage());
        }
    }


}
