package com.wql.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: optionalGrowTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/18 20:03
 * @version: v1.0
 */
public class optionalGrowTest {
    public static void main(String[] args) {

        //创建集合
        List<String> list = Arrays.asList("WQL","KXJ");

        //创建Optional容器
        Optional<List<String>> list1 = Optional.of(list);

        //通过Optional创建Stream流
        Stream<List<String>> stream = list1.stream();

        //打印流中的元素
        stream.flatMap(x->x.stream()).forEach(System.out::println);
    }
}
