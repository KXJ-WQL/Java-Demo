package com.reactor.demo.handler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.handler
 * @className: HandlerFluxDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/27 0:09
 * @version: v2.0
 */
public class HandlerFluxDemo {

    public static void main(String[] args) {
        procee();
    }

    private static void handleProcee(){
        Flux.just(1,2,3,4,5,6)
                .handle((value, sink) -> {
                    if( value % 2 == 0)
                        sink.next(value * value); // 假如是偶数求平方和
                    else if (value > 4)
                        sink.complete(); // 正常结束
                }).subscribe(System.out::println); //输出：4 16
    }

    private static void procee(){
        // 创建消息处理器类
        UnicastProcessor<Object> procees = UnicastProcessor.create();

        // 上游发布
        Flux.just("A", "B", "C")
                .doOnNext(s -> System.out.println("上游发送："+s))
                .subscribe(procees);

        // 处理器处理并发布到下游消费者
        procees.map(data -> data + "-process")
                .subscribe(System.out::println);

    }

}
