package com.kxj.log4j.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
 * @Author WQL-KXJ
 * @ProjectName Log4j-Dome
 * @PackageName com.kxj.log4j.test
 * @Date 2022/11/3 12:05
 * @Version 1.0
 */
public class Log4jTest1 {

    @Test
    public void test1(){
        //加载初始化配置
        //BasicConfigurator.configure();

        //LogLog.setInternalDebugging(true);
        //logger入口程序
        Logger logger = Logger.getLogger(Log4jTest1.class);

        logger.trace("输出trace日志等级");
        logger.debug("输出debug日志等级");
        logger.info("输出info日志等级");
        logger.warn("输出warn日志等级");
        logger.error("输出error日志等级");
        logger.fatal("输出fatal日志等级");

    }


}
