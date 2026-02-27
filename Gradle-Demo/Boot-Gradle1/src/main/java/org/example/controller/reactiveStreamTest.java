package org.example.controller;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @projectName: Boot-Gradle1
 * @package: org.example.controller
 * @className: reactiveStreamTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/7 0:45
 * @version: v2.0
 */
public class reactiveStreamTest {

    public static void main(String[] args) throws InterruptedException {

        // 内置Publisher生产者：SubmissionPublisher是一个简单实现
        SubmissionPublisher<String> submissionPublisher = new SubmissionPublisher<>();

        // 创建Subscriber订阅者
        Flow.Subscriber<Object> subscriber = new Flow.Subscriber<>() {

            // 声明订阅关系全局变量
            private Flow.Subscription subscription;

            @Override // 初次绑定连接时回调
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription; // 赋值绑定关系给全局变量
                // 请求第一个元素
                subscription.request(1);
            }

            @Override // 接收发布者的数据流时回调
            public void onNext(Object item) {
                // 打印元素
                System.out.println("流消息：" + item);
                // 每处理完一个，再请求一个
                subscription.request(1);
            }

            @Override // 出现异常时触发，流终止
            public void onError(Throwable throwable) {
                System.out.println("流消息异常！");
            }

            @Override // 正常结束时触发
            public void onComplete() {
                System.out.println("流消息处理完成！");
            }
        };

        // 创建处理器
        myProcessor myProcessor = new myProcessor();

        // 生产者绑定订阅关系到处理器
        submissionPublisher.subscribe(myProcessor);
        // 处理器绑定订阅关系到订阅者
        myProcessor.subscribe(subscriber);

        // 生产者发布数据
        for (int a= 1; a<11; a++){
            // 发布数据
            submissionPublisher.submit("Hello, Reactive Streams - " + a);
        }

        // 堵塞主线程让响应式处理
        Thread.sleep(10000);
    }


    static class myProcessor extends SubmissionPublisher<String> implements  Flow.Processor<String, String>{

        // 声明订阅关系全局变量
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription; // 赋值绑定关系给全局变量
            // 请求第一个元素
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            // 加工处理元素
            item = item + "-processor";
            // 把加工后的数据发布给下一个处理器或订阅者
            submit(item);
            // 每处理完一个，再请求一个
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {}

        @Override
        public void onComplete() {}
    }

}
