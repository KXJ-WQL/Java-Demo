package com.reactor.demo.subscribe;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.subscribe
 * @className: CustomizeSubscriber
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/25 10:34
 * @version: v2.0
 */
public class CustomizeSubscriber {
    public static void main(String[] args) {
        rangeFlux().subscribe(new MySubscript());
    }

    private static Flux rangeFlux(){
        return Flux.just(1,2,3,4,5).map(x->"ha_"+x);
    }

}

// 继承实现BaseSubscriber抽象类
class MySubscript extends BaseSubscriber{
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("建立订阅关系");
        // 请求一次数据
        subscription.request(1);
    }

    @Override
    protected void hookOnNext(Object value) {
        System.out.println("收到一个元素："+value);
        // 请求下一次数据
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("流正常结束！");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("流出现错误："+throwable.getMessage());
        super.hookOnError(throwable);
    }

    @Override
    protected void hookOnCancel() {
        System.out.println("流被取消！");
        super.hookOnCancel();
    }

    @Override
    protected void hookFinally(SignalType type) {
        System.out.println("流最终结束！");
        super.hookFinally(type);
    }
}
