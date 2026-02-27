package com.WQL.control;

import com.WQL.server.async_server;
import com.WQL.util.MessageUtil2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.control
 * @Date 2024/3/28 22:27
 * @Version 1.0
 */
@RestController
@Slf4j
public class async_control {

    @Autowired
    async_server async_server;


    @GetMapping("/pool")
    public String mainPool(){
        String[] name = new String[]{"寒冰","蛮王","盖伦","皇子","吸血鬼","小丑","蔚","剑魔","猴子","琴女"};
        for (int i=0;i<name.length;i++){
            async_server.processName(name[i],i+1);
        }
        log.info("结束");
        return MessageUtil2.getValueByKey("A100");
    }

    @GetMapping("/poolcompletable")
    public String poolcompletable(){
        String[] name = new String[]{"寒冰","蛮王","盖伦","皇子","吸血鬼","小丑","蔚","剑魔","猴子","琴女"};
        //新建一个CompletableFuture数组
        CompletableFuture<String>[] completableFuture = new CompletableFuture[10];
        for (int i=0;i<name.length;i++){
            completableFuture[i] = async_server.processName2(name[i],i+1);
        }

        //阻塞等待所有Completable响应结果
        CompletableFuture.allOf(completableFuture).join();


        log.info("结束");

        return "out.toString()";
    }
}
