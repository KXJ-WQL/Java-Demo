package com.example.springsecuritybasedemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @projectName: SpringSecurity6-Demo
 * @package: com.example.springsecuritybasedemo.utils
 * @className: JwtUtil
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/6/4 10:26
 * @version: v2.0
 */
public class JwtUtil {

    // JWT 使用的秘钥（对称加密 HMAC256 的 key）
    private static final String SECRET = "wqlhyn$#21d.";

    // JWT 签发者标识（可以用系统名称、服务名等）
    private static final String ISSUER = "wql";

    // 默认过期时间（单位：天）
    private static final int EXPIRE_DAYS = 7;

    // 加密算法对象（基于 SECRET）
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    // 生成 JWT Token
    public static String generateToken(String subject, Map<String, String> claims) {
        // 获取当前时间的 Calendar 实例
        Calendar calendar = Calendar.getInstance();
        // 当前时间作为 token 的签发时间
        Date issuedAt = calendar.getTime();
        // 将时间向后推移 EXPIRE_DAYS 天，作为过期时间
        calendar.add(Calendar.DATE, EXPIRE_DAYS);
        // 获取过期时间
        Date expiresAt = calendar.getTime();

        JWTCreator.Builder builder = JWT.create()// 创建 JWT 构造器
                .withIssuer(ISSUER) // 设置签发者（可用于验证来源）
                .withSubject(subject) // 设置主题（如 userId，唯一标识该用户）
                .withIssuedAt(issuedAt) // 设置签发时间（iat 字段）
                .withExpiresAt(expiresAt); // 设置过期时间（exp 字段）

        // 如果有自定义 Claim 字段(遍历添加所有自定义 Claim（只支持 String 类型）)
        if (claims != null) claims.forEach((k, v) -> builder.withClaim(k, v));

        // 使用指定算法签名，并返回最终 token 字符串
        return builder.sign(algorithm);
    }

    // 验证 JWT 并返回解码对象
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
        // 创建 JWT 验证器，使用相同的签名算法
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER) // 指定签发者（只有匹配的 token 才能验证成功）
                .build(); // 构建验证器对象

        // 使用验证器验证 token（合法则返回解码对象，否则抛异常）
        return verifier.verify(token);
    }

    // 从 token 中解析 claim 字段
    public static String getClaim(String token, String claimKey) {
        // 先验证并解码 token
        DecodedJWT jwt = verifyToken(token);
        // 获取指定字段的值（默认转为 String 类型）
        return jwt.getClaim(claimKey).asString();
    }

    // 判断 token 是否过期
    public static boolean isTokenExpired(String token) {
        try {
            // 验证并解码 token
            DecodedJWT jwt = verifyToken(token);
            Date expiresAt = jwt.getExpiresAt(); // 获取过期时间字段
            return expiresAt.before(new Date()); // 如果过期时间在当前时间之前，则说明已过期
        } catch (JWTVerificationException e) {
            return true;
        }
    }
}
