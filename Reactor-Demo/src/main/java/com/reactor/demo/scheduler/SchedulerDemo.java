package com.reactor.demo.scheduler;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.scheduler
 * @className: SchedulerDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/27 13:48
 * @version: v2.0
 */
public class SchedulerDemo {

    public static void main(String[] args) throws InterruptedException {

        // 1.当前线程执行
        Flux.just(1,2,3,4)
                .map(x -> "h_"+x)
                .subscribeOn(Schedulers.immediate())
                .log()
                .subscribe();// [ INFO] (main) onNext(h_1) 在main主线程执行

        // 2.所有任务都在同一个线程排队顺序执行
        Flux.range(1, 3)
                .publishOn(Schedulers.single())
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
                // 输出：single-1 -> 1

        // 3.多个线程并行
        Flux.range(1, 10)
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
                //输出：parallel-1 -> 1

        // 4.弹性线程池
        Flux.range(1, 5)
                .publishOn(Schedulers.boundedElastic())
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

        Thread.sleep(20000);
    }



}
