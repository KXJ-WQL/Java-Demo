package com.WQL.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.thymeleaf.spring5.context.SpringContextUtils;

import java.util.Locale;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.util
 * @Date 2024/3/18 14:47
 * @Version 1.0
 */
@Component
public class MessageUtil {
    @Autowired
    private MessageSource messageSource;
    public String getValueByKey(String key){
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }
}
