package com.reactor.demo.log;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.log
 * @className: ReactorLogDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/24 19:45
 * @version: v2.0
 */
public class ReactorLogDemo {

    public static void main(String[] args) {
        log().subscribe(System.out::println);
    }

    private static Flux log(){
        return Flux.just(1,3,4,5,6)
                // 只打印流正常结束的日志
                .log("MyFlux", Level.INFO,  SignalType.ON_COMPLETE);
    }

}
