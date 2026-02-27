package com.reactor.demo.sequence;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.stream.IntStream;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.sequence
 * @className: DynamicsCreateDemo
 * @author: WQL-KXJ
 * @description: TODO 编程方式创建序列
 * @date: 2025/4/25 16:00
 * @version: v2.0
 */
public class DynamicsCreateDemo {

    public static void main(String[] args) {
        createFlux();
    }

    public static void generateFlux(){
        Flux.generate(
                () -> 0, // 源数据
                (state, sink)->{
                     sink.next("第"+state+"个数据");
                     if (state == 5) sink.complete(); //手动结束
                     return state+1; //更新源数据
                }).subscribe(System.out::println);
    }

    public static void createFlux(){
        Flux.create(fluxSink -> {
            // 创建用户登录监听对象
            MyListener myListener = new MyListener(fluxSink);
            // 创建100个用户
            IntStream.range(1,100).forEach(x->myListener.online("空想家"+x));
        }).subscribe(System.out::println);
    }
}

class MyListener{
    FluxSink<Object> sink;

    public MyListener(FluxSink<Object> sink) {
        this.sink = sink;
    }

    public void online(String username){
        System.out.println("用户登录：" + username);
        sink.next(username);
    }
}
