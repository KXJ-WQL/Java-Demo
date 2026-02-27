package com.WQL.util;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.util
 * @Date 2024/3/27 16:11
 * @Version 1.0
 */

public class MessageUtil2  {

    public static String getValueByKey(String key){
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }
}
