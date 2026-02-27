package com.reactor.demo.error;

import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.error
 * @className: ErrorHandlerDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/27 14:54
 * @version: v2.0
 */
public class ErrorHandlerDemo {

    public static void main(String[] args) {

       // 1.出错时返回默认值
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorReturn(-1)
                .subscribe(System.out::print); // 输出：1 0 0 -1
        System.out.println();

        // 2.出错时返回兜底方法值
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorResume(e -> Flux.just(100,200))
                .subscribe(System.out::print); // 输出：1 0 0 100 200
        System.out.println();

        // 3.出错时把异常类型转换成另一种异常
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorMap(e -> new RuntimeException("错误转换"))
                .subscribe(val -> System.out.print(val),err -> System.out.print(err)); // 输出：1 0 0 java.lang.RuntimeException: 错误转换
        System.out.println();

        // 4.出错时监听器，不改变流向
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .doOnError(e -> System.out.println("出现异常"+e.getMessage()))
                .subscribe(val -> System.out.print(val),err -> System.out.print(err)); // 输出：1 0 0 出现异常/ by zero
        System.out.println();


        // 5.出错时直接结束
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorComplete()
                .subscribe(val -> System.out.print(val),err -> System.out.print(err),
                           ()->{System.out.println("正常结束");}); // 输出：1 0 0 正常结束
        System.out.println();

        // 6.出错跳过当前元素，继续后面
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorContinue((e, o) -> System.out.println("跳过错误元素: " + o))
                .subscribe(val -> System.out.print(val),err -> System.out.print(err)); // 输出：1 0 0 跳过错误元素: 0
        System.out.println();

        // 7.强制停止
        Flux.just(1,2,3,0)
                .map(x -> 1/x)
                .onErrorStop()
                .subscribe(val -> System.out.print(val),err -> System.out.print(err));
    }

    // 订阅者端错误处理
    private void ErrorHandler(){
        Flux.just(1,2,0,4)
                .map(x-> 1/x)
                .subscribe(val -> System.out.println(val),
                        error-> System.out.println(error));
    }
}
