package com.wql.test;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @projectName: java9-demo
 * @package: com.wql.test
 * @className: tryTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/4/6 20:57
 * @version: v1.0
 */
public class tryTest {

    public static void main(String[] args) {
        JDK7Try();
    }

    //JDK1.7 try语句 手动关闭资源
    public static void JDK7Try(){
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            char[] cbuf = new char[20];
            int len;
            if((len = reader.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //JDK1.8 try语句 自动关闭资源(必须在try中进行初始化)
    public static void JDK8Try(){
        //在try子句中将资源初始化
        try(InputStreamReader reader = new InputStreamReader(System.in)) {
            char[] cbuf = new char[20];
            int len;
            if((len = reader.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //JDK9 try语句 自动关闭资源(可以不在try中进行初始化)
    public static void JDK9Try(){
        //在try子句中将资源初始化
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader) {
            char[] cbuf = new char[20];
            int len;
            if((len = reader.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
