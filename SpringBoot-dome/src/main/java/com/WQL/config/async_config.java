package com.WQL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.config
 * @Date 2024/3/28 23:18
 * @Version 1.0
 */
@Configuration
@EnableAsync//启用Spring异步方法和线程池
public class async_config {

    //定义线程池
    @Bean("mainThreadPool")
    public Executor mainThreadPool(){
        //Spring内部提供的线程池
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        //1.核心线程数：线程池创建时候初始化的线程数
        threadPoolTaskExecutor.setCorePoolSize(10);
        //2.最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        threadPoolTaskExecutor.setMaxPoolSize(20);
        //3.缓存队列：用来缓冲执行任务的队列
        threadPoolTaskExecutor.setQueueCapacity(500);
        //4.允许线程存活的时间(s)：当超过核心线程之外的线程在空闲时间到达之后会被销毁
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        //5.缓冲队列满之后的拒绝策略：由调用线程处理(一般主线程)
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        //线程池名的前缀：方便定位处理任务所在的线程池
        threadPoolTaskExecutor.setThreadNamePrefix("mainThreadPool");
        //线程池初始化
        threadPoolTaskExecutor.initialize();
        return  threadPoolTaskExecutor;
    }

}
