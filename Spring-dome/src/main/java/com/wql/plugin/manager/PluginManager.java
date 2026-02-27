package com.wql.plugin.manager;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.wql.interfaces.IPlugins;

import java.lang.reflect.Constructor;
import java.nio.file.Path;

/**
 * @projectName: Spring-dome
 * @package: com.wql.plugin.manager
 * @className: PluginManager
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/12/5 16:25
 * @version: v2.0
 */
public class PluginManager {

    // BeanFactory对象
    private final DefaultListableBeanFactory defaultListableBeanFactory;

    public PluginManager(DefaultListableBeanFactory defaultListableBeanFactory) {
        this.defaultListableBeanFactory = defaultListableBeanFactory;
    }

    public void loader(Path jarPath, String className) throws Exception {

        // 1.动态加载JAR
        PluginClassLoader pluginClassLoader = new PluginClassLoader(jarPath);

        // 2.加载插件类
        Class<?> aClass = pluginClassLoader.loadClass(className);

        // 3.实例化插件对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object pluginInstance = declaredConstructor.newInstance();

        // 4.注册到IOC容器中
        defaultListableBeanFactory.registerSingleton(className,pluginInstance);

        // 5.初始化插件
        if (pluginInstance instanceof IPlugins){
            IPlugins pluginInstance1 = (IPlugins) pluginInstance;
            pluginInstance1.Init();
        }
    }
}
