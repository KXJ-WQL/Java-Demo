package com.WQL.config;

import com.WQL.util.SpringUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.config
 * @Date 2024/3/27 16:43
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(value= SpringUtil.class)
public class util_config {

    @Bean
    public SpringUtil getSpringUtil(){
        //将Spring工具类假如容器
        return new SpringUtil();
    }
}
