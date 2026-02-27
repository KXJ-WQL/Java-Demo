package com.wql

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @projectName: Gradle-Module-Demo 
 * @package: com.wql
 * @className: text
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/3/24 16:42
 * @version: v2.0
 */
class Text implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.task("wql-kxj"){
            doLast {
                println "BuildSrc插件！！！！"
            }
        }
    }
}
