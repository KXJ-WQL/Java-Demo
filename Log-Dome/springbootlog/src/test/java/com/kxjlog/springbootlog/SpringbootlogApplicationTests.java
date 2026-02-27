package com.kxjlog.springbootlog;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Target;

@SpringBootTest
@Slf4j
class SpringbootlogApplicationTests {


    @Test
    void test(){
        log.trace("trace信息");
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
    }

    @Test
    void contextLoads() {
        Logger logger = LoggerFactory.getLogger(SpringbootlogApplicationTests.class);

            logger.trace("trace信息");
            logger.debug("debug信息");
            logger.info("info信息");
            logger.warn("warn信息");
            logger.error("error信息");

    }

}
