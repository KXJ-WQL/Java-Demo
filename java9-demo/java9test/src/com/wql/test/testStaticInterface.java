package com.wql.test;

import com.wql.test.myinterface.staticInterface;
import com.wql.test.myinterface.staticInterfaceImpl;
import com.wql.test.myinterface.staticInterface;
/**
 * @projectName: java9-demo
 * @package: com.wql.test.myinterface
 * @className: testStaticInterface
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 17:01
 * @version: v1.0
 */
public class testStaticInterface {
    public static void main(String[] args) {
        //创建接口实现类
        staticInterfaceImpl staticInterface = new staticInterfaceImpl();
        //通过静态接口方法传入对象并调用默认方法
        com.wql.test.myinterface.staticInterface.callDefaultMethod(staticInterface);
    }
}
