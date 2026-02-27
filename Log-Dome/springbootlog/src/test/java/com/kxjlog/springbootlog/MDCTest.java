package com.kxjlog.springbootlog;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @projectName: springbootlog
 * @package: com.kxjlog.springbootlog
 * @className: MDCTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/11 10:05
 * @version: v2.0
 */
@SpringBootTest
@Slf4j
public class MDCTest {

    @Test
    public void MDCThreadSwitching(){
        // 设置MDC上下文
        MDC.put("requestID","123");
        // 记录日志，日志会携带MDC信息
        log.info("MDC上下文设置完成");

        //启动一个子线程处理
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            log.info("子线程输出MDC-{}",MDC.get("requestID"));
        });

        // 清除当前线程的MDC信息
        MDC.clear();
    }

    @Test
    public void MDCThreadSwitchingSolve(){
        // 设置MDC上下文
        MDC.put("requestID","123");
        // 记录日志，日志会携带MDC信息
        log.info("MDC上下文设置完成");

        // 获取当前线程的的上下文的浅拷贝数据对象
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();

        //启动一个子线程处理
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            //将父线程的MDC上下文数据设置到当前线程的MDC上下文
            MDC.setContextMap(copyOfContextMap);
            log.info("子线程输出MDC-{}",MDC.get("requestID"));
        });

        // 清除当前线程的MDC信息
        MDC.clear();
    }

    @Test
    public void MDCThreadReuse(){

        // 创建可复用固定线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 任务1
        Runnable run1 = ()->{
            try {
                MDC.put("userId", "user1");
                log.info("任务1运行: {}", MDC.get("userId"));
            } finally {
                MDC.clear();
            }
        };

        // 任务2
        Runnable run2 = ()->{
            log.info("任务2运行: {}", MDC.get("userId"));
        };

        executorService.submit(run1);
        executorService.submit(run2);
        executorService.submit(run2);
    }

}
