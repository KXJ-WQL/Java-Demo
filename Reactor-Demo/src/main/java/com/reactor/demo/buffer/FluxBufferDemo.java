package com.reactor.demo.buffer;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.buffer
 * @className: FluxBufferDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/25 11:30
 * @version: v2.0
 */
public class FluxBufferDemo {

    public static void main(String[] args) throws InterruptedException {
        bufferpredicate();
        // Thread.sleep(20000);
    }

    // 1.固定长度缓存分组
    private static void bufferSize(){
        Flux.range(10,4)
            .buffer(3) // 3个元素为一组
            .subscribe(System.out::println);
        // request(1): [10, 11, 12]
        // request(2): [13]
    }

    // 2.指定窗口大小和步长分组缓存
    private static void bufferSkipSize(){
        Flux.range(1,5)
                .buffer(3,2) // 数量3 步长2，每组有一个元素重复
                .subscribe(System.out::println);
        // request(1): [1, 2, 3]
        // request(2): [3, 4, 5]
        // request(2): [5]
    }

    // 3.指定间隔时间分组缓存
    private static void bufferInterval(){
        Flux.interval(Duration.ofMillis(500))
                .take(8) //最多生成8个元素
                .buffer(Duration.ofSeconds(1)) // 每秒收集一次元素
                .subscribe(System.out::println);
        // request(1): [0, 1]
        // request(2): [2]
        // request(3): [3, 4, 5]
        // request(4): [6, 7]
    }

    // 4.混合条件分组，当数量和时间满足就分组
    private static void bufferTime(){
        Flux.interval(Duration.ofMillis(500))
                .take(10)
                .bufferTimeout(4, Duration.ofSeconds(1)) // 最多4个或1秒一次分组
                .subscribe(System.out::println);
        // [0, 1, 2]
        // [3, 4, 5]
        // [6, 7, 8]
        // [9]
    }

    // 5.遇到匹配元素时就切断并发出
    private static void bufferUntil() {
        Flux.just(1, 2, 3, 4, 5, 6, 7)
                .bufferUntil(i -> i % 3 == 0) // 遇到能被3整除的元素就分组
                .subscribe(System.out::println);
        //[1, 2, 3]
        //[4, 5, 6]
        //[7]
    }

    // 6.连续匹配 predicate 的元素组成一组
    private static void bufferpredicate() {
        Flux.just(1, 2, 3, 0, 4, 5, 0, 6)
                .bufferWhile(i -> i != 0)// 收集不等于0的元素，并根据不等于0进行分组节点
                .subscribe(System.out::println);
    }
    // [1, 2, 3]
    // [4, 5]
    // [6]
}
