package com.WQL.profileinterface;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.profileinterface
 * @Date 2024/3/16 14:23
 * @Version 1.0
 */
@Profile("env")
@Component
@ConfigurationProperties("profilebean")
@Data
@ToString
public class profileEnvBean implements profilebean{
    private String name;
    private String mess;
}
