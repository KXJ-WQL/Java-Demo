package com.wql.test;

import com.wql.test.myinterface.defaultInterface;
import com.wql.test.myinterface.defaultInterfaceImpl;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: testInterface
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 16:54
 * @version: v1.0
 */
public class testInterface {
    public static void main(String[] args) {
        //1.直接通过接口名调用接口静态方法
        defaultInterface.staticMethod();
        //2.实例化子类实现
        defaultInterfaceImpl d = new defaultInterfaceImpl();
        d.commonMethod();
    }
}
