package com.wql.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: outputstreamGrow
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/18 21:04
 * @version: v1.0
 */
public class outputstreamGrow {
    public static void main(String[] args) {
        ClassLoader classLoader = outputstreamGrow.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("hello.txt");
        try (is){
            FileOutputStream fileOutputStream = new FileOutputStream("src\\hello.txt");
            //减数据直接转换到OutputStream中
            is.transferTo(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
