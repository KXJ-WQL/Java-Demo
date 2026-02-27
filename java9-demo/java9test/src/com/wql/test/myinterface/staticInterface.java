package com.wql.test.myinterface;

/**
 * @projectName: java9-demo
 * @package: com.wql.test.myinterface
 * @className: staticInterface
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 16:58
 * @version: v1.0
 */
public interface staticInterface {
   default void myDefaultMethod(){
       System.out.println("实现类调用默认方法！");
   };

    static void callDefaultMethod(staticInterface obj) {
        obj.myDefaultMethod(); // 在静态方法中调用默认方法
    }
}
