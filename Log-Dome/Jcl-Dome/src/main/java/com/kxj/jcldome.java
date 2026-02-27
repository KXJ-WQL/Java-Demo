package com.kxj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/*
 * @Author WQL-KXJ
 * @ProjectName Jcl-Dome
 * @PackageName com.kxj
 * @Date 2022/11/7 12:11
 * @Version 1.0
 */
public class jcldome {

    @Test
    public void test1(){
        LogLog.setInternalDebugging(true);
        //提供LogFactory获取log
        Log log = LogFactory.getLog(jcldome.class);
        //打印日志
        log.info("jcl日志门面");


    }
}
