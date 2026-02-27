package com.reactor.demo.subscribe;

import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.subscribe
 * @className: builtInSubscribe
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/25 9:40
 * @version: v2.0
 */
public class BuiltInSubscribe {

    public static void main(String[] args) {
        // 简单触发流
        subscribeRange().subscribe();
        // 快速测试流
        subscribeRange().subscribe(System.out::print);
        System.out.println();
        // 捕获错误
        subscribeRange().subscribe(
                value -> System.out.print(value),
                error -> System.out.print("出现错误"+error));
        // 流处理完成回调
        System.out.println();
        subscribeRange().subscribe(
                value -> System.out.print(value),
                error -> System.out.print("出现错误"+error),
                () -> System.out.println("流处理完成"));
        // 订阅加请求控制
        Flux.range(1, 10)
                .subscribe(
                        value -> System.out.println("收到：" + value),
                        err -> System.err.println("出错：" + err),
                        () -> System.out.println("流结束"),
                        subscription -> {
                            System.out.println("建立订阅");
                            subscription.request(2); // 只请求2个元素
                        }
                );
    }

    private static Flux subscribeRange(){
       return Flux.range(10,5).map(x->"ha_"+x+"  ");
    }
}
