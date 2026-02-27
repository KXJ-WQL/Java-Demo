package com.wql.test.myinterface;

/**
 * @projectName: java9-demo
 * @package: com.wql.test.myinterface
 * @className: defaultInterface
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 16:48
 * @version: v1.0
 */
public interface defaultInterface {

    //定义普通的接口方法
    void commonMethod();

    //定义静态方法
    static void staticMethod(){
        System.out.println("接口静态方法");
    }

    //定义默认方法
     default void defaultMethod(){
        System.out.println("接口默认方法");
        //调用私有
        privateMethod();
    }

    //定义私有的普通接口方法(不能被实现只能在当前接口中被调用)
    private void privateMethod(){
        System.out.println("私有的普通接口方法");
    };
}
