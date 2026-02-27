package com.reactor.demo.sequence;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.sequence
 * @className: FluxDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/20 14:12
 * @version: v2.0
 */
public class FluxDemo {
    public static void main(String[] args) {
        createFlux().subscribe(System.out::println,err->{
            System.out.println(err);
        });
    }

    public static Flux createFlux(){
        // 创建包含多个固定值的Flux
        Flux justFlux = Flux.just("A", "B", "C");
        // 从集合中创建Flux
        List<String> x = List.of("X", "Y", "Z");
        Flux<String> fromIterableFlux = Flux.fromIterable(x);
        // 创建一个范围序列(start起始数，count获取几个数)
        Flux<Integer> rangeFlux = Flux.range(5, 3);
        // 创建一个空的序列
        Flux<Object> emptyFlux = Flux.empty();
        // 创建一个立即抛出错误的序列
        Flux<Object> errorFlux= Flux.error(new RuntimeException("错误序列"));
        // 创建一个定时发出数字的Flux(Duration对象指定时间，take发送几次)
        Flux<Long> takeFlux = Flux.interval(Duration.ofSeconds(1)).take(3);
        // 同步的按需生成数据
        Flux<Object>  generateFlux = Flux.generate(sink -> {
            sink.next("生成一个值");
            sink.complete();
        });
        // 异步或事件驱动方式创建Flux
        Flux<Object> createFlux = Flux.create(sink -> {
            sink.next("来自事件1");
            sink.next("来自事件2");
            sink.complete();
        });
        // 延迟创建Flux
        Flux<String> defer = Flux.defer(() -> {
            System.out.println("构建Flux");
            return Flux.just("A","B");
        });
        return defer;
    }
}
