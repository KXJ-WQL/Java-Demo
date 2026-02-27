package com.reactor.demo.operationapi;

import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.operationapi
 * @className: CollectApiDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/26 22:55
 * @version: v2.0
 */
public class CollectApiDemo {
    public static void main(String[] args) {

        // 1.CollectList 聚合成列表
        Flux.just(1,2,3,4)
                .collectList()
                .subscribe(System.out::println); // 输出：[1, 2, 3, 4]

        // 2.reduce() 和并元素为一个值
        Flux.just(1,2,3,4)
                .reduce((a,b) -> a+b)
                .subscribe(System.out::println); // 输出：10

        // 3.count()计数
        Flux.just(1,2,3,4)
                .count()
                .subscribe(System.out::println); // 输出：4

        // 4.collectMap收集元素为map，需要提供key
        Flux.just(1,2,3,4)
                .collectMap(x-> "map_"+x)
                .subscribe(System.out::println); // 输出：{map_2=2, map_1=1, map_4=4, map_3=3}
    }
}
