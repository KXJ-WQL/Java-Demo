package com.WQL.profileinterface;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.profileinterface
 * @Date 2024/3/16 14:24
 * @Version 1.0
 */
@Profile("prod")
@Component
@ConfigurationProperties("profilebean")
@Data
@ToString
public class profileProdBean implements profilebean {
    private String name;
    private String mess;
}
