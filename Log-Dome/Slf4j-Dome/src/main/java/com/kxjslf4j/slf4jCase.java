package com.kxjslf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * @Author WQL-KXJ
 * @ProjectName Slf4j-Dome
 * @PackageName com.kxjslf4j
 * @Date 2022/11/7 21:47
 * @Version 1.0
 */
public class slf4jCase {

    @Test
    public void test(){

        Logger logger = LoggerFactory.getLogger(slf4jCase.class);

        //日志记录代码
        for (int a=0;a<100;a++) {
            logger.trace("trace日志");
            logger.debug("debug日志");
            logger.info("info日志");
            logger.warn("warn日志");
            logger.error("error日志");
        }

        //假设为业务逻辑代码
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("-=-=-=-=-----=-=-=-=-=-=-=-=-=-=-=-----=-=-");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    @Test
    public void test1(){
        String level ="info";
        String mes = "啥也没有";
        Logger logger = LoggerFactory.getLogger(slf4jCase.class);

        logger.info("日志级别:{},信息:{}",level,mes);
    }

    @Test
    public void test2(){

        Logger logger = LoggerFactory.getLogger(slf4jCase.class);

        try {
            Class.forName("aaa");//aaa不存在
        }catch (ClassNotFoundException e){
            logger.info("异常信息",e);
        }
    }

    @Test
    public void test3(){
        //调用Log4j的LogManager管理类进行获取logger对象
//        Logger logger = LogManager.getLogger(slf4jCase.class);
//
//        logger.info("log4j日志重构");

    }

}
