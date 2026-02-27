package com.wql.plugin.manager;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

/**
 * @projectName: Spring-dome
 * @package: com.wql.plugin.manager
 * @className: PluginClassLoader
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/12/5 16:37
 * @version: v2.0
 */
public class PluginClassLoader extends URLClassLoader {

    // 类加载器
    public PluginClassLoader(Path jarPath) throws Exception {
        super(new URL[]{jarPath.toUri().toURL()});
    }
}
