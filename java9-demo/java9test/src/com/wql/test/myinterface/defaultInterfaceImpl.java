package com.wql.test.myinterface;

/**
 * @projectName: java9-demo
 * @package: com.wql.test.myinterface
 * @className: defaultInterfaceImpl
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 16:55
 * @version: v1.0
 */
public class defaultInterfaceImpl implements defaultInterface{
    @Override
    public void commonMethod() {
        //调用接口默认方法
        defaultMethod();
    }

    @Override
    public void defaultMethod() {//重写默认方法
        //重写前调用默认方法(super获取超类接口的引用)
        defaultInterface.super.defaultMethod();
        System.out.println("默认方法重写");
    }
}
