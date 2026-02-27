package com.WQL.server;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.server
 * @Date 2024/3/28 23:16
 * @Version 1.0
 */
@Service
@Slf4j
public class async_server {

    @Async("mainThreadPool")
    @SneakyThrows
    public void processName(String name,int num){
        Thread.sleep(new Random().nextInt(2000));
        log.info("序号：{} --- 姓名：{}",num,name);
    }

    @Async("mainThreadPool")
    @SneakyThrows
    public CompletableFuture<String> processName2(String name, int num){
        Thread.sleep(new Random().nextInt(2000));
        log.info("序号：{} --- 姓名：{}",num,name);
        return CompletableFuture.completedFuture("序号："+num+" --- 姓名："+name);
    }

}
