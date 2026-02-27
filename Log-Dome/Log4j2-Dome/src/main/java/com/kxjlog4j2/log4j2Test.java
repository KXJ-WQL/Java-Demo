package com.kxjlog4j2;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @Author WQL-KXJ
 * @ProjectName Log4j2-Dome
 * @PackageName com.kxjlog4j2
 * @Date 2022/11/10 17:17
 * @Version 1.0
 */
public class log4j2Test {

    @Test
    public void test(){

        //获取Logger对象
        //Logger logger = LogManager.getLogger(log4j2Test.class);

        //打印日志级别
//        logger.trace("trace信息");
//        logger.debug("debug信息");
//        logger.info("info信息");
//        logger.warn("warn信息");
//        logger.error("error信息");
//        logger.fatal("fatal信息");

    }

    @Test
    public void hh(){

        Logger logger = LoggerFactory.getLogger(log4j2Test.class);
        for (int a=0;a<20;a++){
            logger.trace("trace信息");
            logger.debug("debug信息");
            logger.info("info信息");
            logger.warn("warn信息");
            logger.error("error信息");
            }
        System.out.println("--==--==--==--==--==--==--==--==--==");
        System.out.println("--==--==--==--==--==--==--==--==--==");
        System.out.println("--==--==--==--==--==--==--==--==--==");


    }

}
