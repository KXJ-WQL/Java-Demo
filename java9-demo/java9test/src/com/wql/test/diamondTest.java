package com.wql.test;

import com.wql.test.bean.Box;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: diamondTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 21:44
 * @version: v1.0
 */
public class diamondTest {
    public static void main(String[] args) {

        // JDK 7 及之前的方式，需要在构造器中显式指定类型参数
        Box<String> box1 = new Box<String>("Apple");
        System.out.println("Box 1 contains: " + box1.getTirm());

        // JDK 9 改进后的方式，使用钻石操作符
        Box<Integer> box2 = new Box<>(123);
        System.out.println("Box 2 contains: " + box2.getTirm());
    }
}
