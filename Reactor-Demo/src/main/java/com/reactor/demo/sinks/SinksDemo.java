package com.reactor.demo.sinks;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.sinks
 * @className: SinksDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/28 15:04
 * @version: v2.0
 */
public class SinksDemo {

    public static void main(String[] args) {

        Sinks.Many<Object> objectMany = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> objectFlux = objectMany.asFlux();

        objectFlux.subscribe(x -> System.out.println("收到数据: "+x));

        objectMany.tryEmitNext(1);
        objectMany.tryEmitNext(2);
        objectMany.tryEmitNext(3);

        // 输出：
        // 收到数据: 1
        //收到数据: 2
        //收到数据: 3
    }



}
