package com.wql.test;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: streamGrowTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/18 18:31
 * @version: v1.0
 */
public class streamGrowTest {
    public static void main(String[] args) {

        //创建空了Stream流
        Stream<Integer> integerStream = Stream.ofNullable(null);
        //通过iterate创建Stream有限流
        Stream.iterate(0,i->i<100,i->i+10).forEach(System.out::println);

    }
    public static void takeWhile(){
        //使用of创建一个Stream流
        Stream<Integer> integerStream = Stream.of(1, 12, 45, 23, 17, 29, 30, 21, 11, 98);
        //返回从开头开始从第一次条件判断为false这段元素
        integerStream.takeWhile(x->x<30).forEach(System.out::println);
    }

    public static void dropWhile(){
        //使用of创建一个Stream流
        Stream<Integer> integerStream = Stream.of(1, 12, 45, 23, 17, 29, 30, 21, 11, 98);
        //返回从开头开始从第一次条件判断为false这段元素之外的所以元素
        integerStream.dropWhile(x->x<30).forEach(System.out::println);
    }
}
