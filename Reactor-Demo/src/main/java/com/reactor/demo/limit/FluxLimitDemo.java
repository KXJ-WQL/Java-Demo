package com.reactor.demo.limit;

import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.limit
 * @className: FluxLimitDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/25 14:02
 * @version: v2.0
 */
public class FluxLimitDemo {

    public static void main(String[] args) {
        limitTake();
    }

    private static void limitRate(){
        Flux.range(1,1000)
                .log()
                .limitRate(100) // 每次取100个数据，有75%的预取策略
                .subscribe(System.out::println);
    }

    private static void limitRequest(){
        Flux.range(1,1000)
                .log()
                .limitRequest(100) // 只请求100次数据
                .subscribe(System.out::println);
    }

    private static void limitTake(){
        Flux.range(1,10)
                .log()
                .buffer(2)
                .take(2)
                .subscribe(System.out::println);
        // [1, 2]
        // [3, 4]
    }

}
