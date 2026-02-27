package com.reactor.demo.operationapi;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.operationapi
 * @className: ConversionApiDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/25 17:52
 * @version: v2.0
 */
public class ConversionApiDemo {

    public static void main(String[] args) {
        defaultIfEmptyExample();
    }

    // 1.map数据流转换
    private static void mapExample(){
        Flux.range(1,5)
                .map(x -> "ha_" + x + " ")
                .subscribe(System.out::print); //输出：ha_1 ha_2 ha_3 ha_4 ha_5
    }

    // 2.flatMap数据流转换并展平
    private static void flatMapExample(){
        Flux.range(1,5)
                .flatMap(x -> Flux.just("flat_" + x + " "))
                .subscribe(System.out::print); // 输出：flat_1 flat_2 flat_3 flat_4 flat_5
    }

    // 3.concatMap流的转换拼接
    private static void concatMapExample(){
        Flux.just(1,2,3)
                .concatMap(x->Flux.just("concatMap_"+ x+ "\t", x+"\t"))
                .subscribe(System.out::print); // 输出：concatMap_1	1	concatMap_2	2	concatMap_3	3
    }

    // 4.concatWith流的拼接
    private static void concatWithExample(){
        Flux.just(1,2,3)
                .concatWith(Flux.just(22, 33, 44))
                .subscribe(System.out::print);// 输出:1 2 3 22 33 44
    }

    // 5.concat流的拼接(Flux静态方法)
    private static void concatExample(){
        Flux.concat(Flux.just(1,2,3), Flux.just(4,5,6))
                .subscribe(System.out::print);// 输出:1 2 3 4 5 6
    }

    // 5.transform流无状态自定义转换，不共享外部变量的值
    private static void transFormExample(){
        // 线程原子类
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux<String> transform = Flux.just("a", "b", "c")
                .transform(values -> {
                    // 如果第一次调用元素全部转换为大写
                    if (atomicInteger.incrementAndGet() == 1)
                        return values.map(String::toUpperCase);
                    else return values; // 否则原封不动返回
                });
        //订阅者1
        transform.subscribe(x-> System.out.print("订阅者1:"+x+"\t"));
        System.out.println();
        //订阅者2
        transform.subscribe(x-> System.out.print("订阅者2:"+x+"\t"));
        //输出：
        // 订阅者1:A	订阅者1:B	订阅者1:C
        // 订阅者2:A	订阅者2:B	订阅者2:C
    }

    // 6.transform流无状态自定义转换，不共享外部变量的值
    private static void transformDeferredExample(){
        // 线程原子类
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux<String> transform = Flux.just("a", "b", "c")
                .transformDeferred(values -> {
                    // 如果第一次调用元素全部转换为大写
                    if (atomicInteger.incrementAndGet() == 1)
                        return values.map(String::toUpperCase);
                    else return values; // 否则原封不动返回
                });
        //订阅者1
        transform.subscribe(x-> System.out.print("订阅者1:"+x+"\t"));
        System.out.println();
        //订阅者2
        transform.subscribe(x-> System.out.print("订阅者2:"+x+"\t"));
        //输出：
        // 订阅者1:A	订阅者1:B	订阅者1:C
        // 订阅者2:a	订阅者2:b	订阅者2:c
    }

    // 7.为空判断
    private static void defaultIfEmptyExample(){
        Mono.empty()
                .defaultIfEmpty("兜底数据") // 兜底静态数据
                .subscribe(System.out::println); //输出：兜底数据

        Mono.empty()
                .switchIfEmpty(emptyValue()) //兜底动态方法
                .subscribe(System.out::println); //输出：动态兜底方法
    }

    private static Mono emptyValue(){
        return Mono.just("动态兜底方法");
    }
}
