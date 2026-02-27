package com.reactor.demo.sequence;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.sequence
 * @className: MonoDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/20 14:12
 * @version: v2.0
 */
public class MonoDemo {

    public static void main(String[] args) throws InterruptedException {
//        createMono().subscribe(System.out::println,err->{
//            System.out.println(err);
//        });
        createMono().subscribe(System.out::println,err->{
            System.out.println(err);
        });
    }

    public static Mono<String> createMono(){
        // 1.创建一个包含单个数据的 Mono
        Mono<Integer> just = Mono.just(1);
        // 2.创建一个不包括任何元素的Mono
        Mono<Object> empty = Mono.empty();
        // 3.创建一个立即终止并发出错误的Mono
        Mono<Object> boom = Mono.error(new RuntimeException("Error"));
        // 4.懒加载数据直到订阅时才执行
        Mono<String> stringMono = Mono.fromSupplier(() -> {return "执行计算";});
        // 5.通过延迟执行Callable获取数据,适合抛出受检异常方法
        Mono<String> eror = Mono.fromCallable(() -> {if (true) throw new RuntimeException("eror");return "error";});
        // 6.延迟Mono的创建，而非立即执行
        Mono<String> defer = Mono.defer(() -> {System.out.println("创建Mono");return Mono.just("D");});
        return defer;
    }


}
