package com.wql.module;

/**
 * @projectName: java9-demo
 * @package: com.wql.module
 * @className: Person
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/5 13:48
 * @version: v1.0
 */
public class Person {

   private String name;
   private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
