package com.reactor.demo.operationapi;

import reactor.core.publisher.Flux;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.operationapi
 * @className: FilterApiDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/26 22:31
 * @version: v2.0
 */
public class FilterApiDemo {

    public static void main(String[] args) {

        // 1.filter过滤
        Flux.just(1,2,3,4)
                .filter(x -> x > 3) // 只需要大于3的元素
                .subscribe(x -> System.out.print("filter: "+x +"\t"));
        System.out.println(); //输出：filter: 4

        // 2.take提取一定数据的元素(正向提取)
        Flux.range(1,4)
                .take(2) // 只发出前面两个元素
                .subscribe(x -> System.out.print("take: "+x +"\t"));
        System.out.println();//输出：take: 1	take: 2

        // 3.takeLast提取一定数据的元素(反向提取)
        Flux.range(1,4)
                .takeLast(2) // 只发出后面两个元素
                .subscribe(x -> System.out.print("takeLast: "+x +"\t"));
        System.out.println();//输出：takeLast: 3	takeLast: 4


        // 4.takeWhile条件成立时取元素
        Flux.range(1,4)
                .takeWhile(x -> x < 2) // 满足条件提取
                .subscribe(x -> System.out.print("takeWhile: "+x +"\t"));
        System.out.println();//输出：takeWhile: 1


        // 5.skip跳过前n个元素
        Flux.range(1,4)
                .skip(2) // 跳过前两个元素
                .subscribe(x -> System.out.print("skip: "+x +"\t"));
        System.out.println();//输出：skip: 3	skip: 4

        // 6.skipWhile跳过前n个元素
        Flux.range(1,4)
                .skipWhile(x -> x == 3) // 跳过值为3的元素
                .subscribe(x -> System.out.print("skipWhile: "+x +"\t"));
        System.out.println();

        // 7.去重
        Flux.just(1,4,3,4,3,5)
                .distinct() // 去重
                .subscribe(x -> System.out.print("distinct: "+x +"\t"));
        System.out.println(); // 输出：distinct: 1	distinct: 4	distinct: 3	distinct: 5
    }

}
