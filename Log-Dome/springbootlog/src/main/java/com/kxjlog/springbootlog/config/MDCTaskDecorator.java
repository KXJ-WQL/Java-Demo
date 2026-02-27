package com.kxjlog.springbootlog.config;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * @projectName: springbootlog
 * @package: com.kxjlog.springbootlog.config
 * @className: MDCTaskDecorator
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/11 11:05
 * @version: v2.0
 */
public class MDCTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable task) {
        // 获取当前父线程的 MDC 上下文
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        // 返回一个新的 Runnable，包装了原始任务 task
        return () -> {
            // MDC不为null, 将 MDC 上下文设置到当前子线程
            if (contextMap != null) MDC.setContextMap(contextMap);

            // 执行任务, 任务执行结束清理 MDC，避免影响其他线程
            try {task.run();} finally {MDC.clear();}
        };
    }
}