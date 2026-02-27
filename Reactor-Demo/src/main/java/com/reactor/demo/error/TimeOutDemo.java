package com.reactor.demo.error;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.io.IOException;
import java.time.Duration;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.error
 * @className: TimeOutDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/27 17:10
 * @version: v2.0
 */
public class TimeOutDemo {

    public static void main(String[] args) throws IOException {

        // 1.普通超时
        Flux.just(1, 2)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)))
                .subscribe(System.out::println, e -> System.err.println("超时啦: " + e));//输出：超时啦: java.util.concurrent.TimeoutException

        // 2.超时后切换到备用流
        Flux.just(1, 2)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2), Flux.just(100, 200))
                .retry(3)
                .subscribe(System.out::println);// 输出：100 200

        System.in.read();

    }

}
