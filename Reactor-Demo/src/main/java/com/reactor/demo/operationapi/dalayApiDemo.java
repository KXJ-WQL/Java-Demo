package com.reactor.demo.operationapi;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.operationapi
 * @className: dalayApiDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/26 23:05
 * @version: v2.0
 */
public class dalayApiDemo {

    public static void main(String[] args) throws InterruptedException {

        // 1.delayElements每个元素发出之间延迟
        Flux.range(1,5)
                .delayElements(Duration.ofMillis(800))
                .subscribe(System.out::println);

        // 2.delaySubscription流订阅时延迟
        Flux.range(10,5)
                .delaySubscription(Duration.ofSeconds(1))
                .subscribe(System.out::println);

        // 3.timeout流超时时间
        Flux.range(20,5)
                .timeout(Duration.ofSeconds(2))
                .subscribe(System.out::println);

        // 4.timestamp给流每个元素加上时间搓
        Flux.range(30,5)
                .timestamp()
                .subscribe(System.out::println);
        // 输出：[1745680180430,30] [1745680180430,31] [1745680180430,32] [1745680180430,33] [1745680180430,34]

        Thread.sleep(200000);
    }

}
