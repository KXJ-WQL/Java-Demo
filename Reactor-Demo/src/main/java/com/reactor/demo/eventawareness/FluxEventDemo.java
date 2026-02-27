package com.reactor.demo.eventawareness;

import jdk.jfr.Event;
import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.eventawareness
 * @className: FluxEventDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/24 12:29
 * @version: v2.0
 */
public class FluxEventDemo {
    public static void main(String[] args) {
        // eventFlux().subscribe(System.out::println);

        fluxEach().subscribe(System.out::println);
    }

    private static Flux eventFlux(){
        return Flux.range(4,3)
                .map(x->{return x;})
                .doFirst(()->System.out.println("最初执行"))
                .doOnEach((x)->System.out.println("信号类型"+x.getType()))
                .doOnSubscribe(x -> System.out.println("\uD83D\uDD17订阅连接建立"))
                .doOnRequest(n -> System.out.println("请求了"+n+"个元素"))
                .doOnNext(i -> System.out.println("处理元素"+i))
                .doOnComplete(()->System.out.println("流处理完成"))
                .doOnCancel(()->System.out.println("流被取消"))
                .doOnError((x)->System.out.println("出现错误"+x))
                .doFinally(x->System.out.println("最终信号"+x));
    }

    private static Flux timingIssues(){
        return Flux.range(4,3)
                .doOnNext(x->System.out.println("map前：" + x)) // 输出: 4 5 6
                .map(x->{return x*2;})
                .doOnNext(x->System.out.println("map前：" + x));// 输出: 8 10 12
    }

    private static Flux fluxEach(){
        return Flux.just(1, 2, 3)
                .map(i -> {
                    return i;
                })
                .doOnEach(signal -> {
                    if (signal.isOnNext()) {
                        System.out.println("✅ onNext: " + signal.get());
                        System.out.println("🏁 获取值："+signal.get());
                    } else if (signal.isOnError()) {
                        System.out.println("❌ onError: " + signal.getThrowable());
                    } else if (signal.isOnComplete()) {
                        System.out.println("🏁 onComplete");
                    }
                });
    }
}
