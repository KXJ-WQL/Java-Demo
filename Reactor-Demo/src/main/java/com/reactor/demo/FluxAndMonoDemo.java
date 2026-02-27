package com.reactor.demo;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo
 * @className: FluxDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/13 16:49
 * @version: v2.0
 */
public class FluxAndMonoDemo {

    public static void main(String[] args) {

        fluxTest();
        Disposable subscribe = Flux.just(1, 2, 3)
                .subscribe();
    }

    public static void monoTest(){
        // Mono：代表0~1个元素
        Mono<Integer> just = Mono.just(1);
        just.subscribe(System.out::println);
    }

    public static void fluxTest(){
        // Flux：代表0~N个元素
        Flux<Integer> just = Flux.just(1, 2, 3, 4, 5);
        // 订阅消费流(流不订阅消费就是一段静态代码)
        just.subscribe(x -> System.out.println("e1 - "+x));
        // 多个消费者订阅流
        just.subscribe(x -> System.out.println("e2 - "+x));
    }
}
