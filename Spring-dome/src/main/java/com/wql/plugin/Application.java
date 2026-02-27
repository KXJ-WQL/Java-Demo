package com.wql.plugin;

import com.wql.plugin.manager.PluginManager;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wql.interfaces.IPlugins;

import java.nio.file.Paths;

/**
 * @projectName: Spring-dome
 * @package: com.wql.plugin
 * @className: Application
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/12/5 16:49
 * @version: v2.0
 */
public class Application {

    public static void main(String[] args) throws Exception {

        // 1.实例化Spring上下文对象
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 2.获取BeanFactory对象
        DefaultListableBeanFactory beanFactory = applicationContext.getDefaultListableBeanFactory();

        // 3.插件管理器
        PluginManager pluginManager = new PluginManager(beanFactory);
        // 4.加载注册插件
        pluginManager.loader(Paths.get("S:\\KxjPlugin-1.0-SNAPSHOT.jar"), "org.wql.KXJPlugin");

        // 5.获取插件
        IPlugins bean = (IPlugins) beanFactory.getBean("org.wql.KXJPlugin");
        System.out.println(bean.getPlugin());
    }

}
