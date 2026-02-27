package com.wql.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: unmodifiableConnections
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/12 21:39
 * @version: v1.0
 */
public class unmodifiableConnections {

    public static void main(String[] args) {


    }

    //jdk8及之前创建只读集合的方式(使用Collections的unmodifiable方法)
    private static void unmodifiableJDK8(){

        //unmodifiableList创建只读List
        List<Integer> integers = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5));

        //unmodifiableSet创建只读set
        Set<String> strings = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("1", "2")));

        //unmodifiableMap创建只读map
        Map<String,Integer> map = Collections.unmodifiableMap(new HashMap<>(){
            {
                put("tom",1);
                put("kot",1);
            }
        });
    }

    //jdk9创建只读集合的方式(不同集合类型的of方法)
    private static void unmodifiableJDK9(){

        //list创建只读集合
        List<String> list = List.of("1", "2", "3");

        //set创建只读集合
        Set<String> set = Set.of("1", "2", "3");

        //map创建只读集合 方式1-使用可变参数
        Map<String,Integer> map2 = Map.of("1", 1, "3",3);
        //map创建只读集合 方式1-使用可变参数Entries
        Map<String,Integer> map3 = Map.ofEntries(Map.entry("tom",1),Map.entry("kon",2));

    }

}
