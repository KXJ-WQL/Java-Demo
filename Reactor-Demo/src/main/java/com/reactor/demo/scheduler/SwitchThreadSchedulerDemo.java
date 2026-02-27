package com.reactor.demo.scheduler;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.scheduler
 * @className: switchThreadSchedulerDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/27 12:20
 * @version: v2.0
 */
public class SwitchThreadSchedulerDemo {

    public static void main(String[] args) throws InterruptedException {
        fluxPublishOn();
        Thread.sleep(200000);

    }

    private static void fluxSubscriberOn(){
        Flux.range(1,5)
                .map(i -> "Subscribe_" + i)
                .log()
                .subscribeOn(Schedulers.single())
                .subscribe();
    }

    private static void fluxPublishOn(){
        Flux.range(1,5)
                .map(i -> "Before_Subscribe_" + i)
                .log()
                .publishOn(Schedulers.single())
                .map(i -> "After_Subscribe_" + i)
                .log()
                .subscribe();
    }


}
