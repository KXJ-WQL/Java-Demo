package com.wql.test.bean;

/**
 * @projectName: java9-demo
 * @package: com.wql.test.bean
 * @className: box
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 21:43
 * @version: v1.0
 */
public class Box<T>{

    private T tirm;

    public Box(T tirm) {
        this.tirm = tirm;
    }

    public T getTirm() {
        return tirm;
    }

    public void setTirm(T tirm) {
        this.tirm = tirm;
    }
}
