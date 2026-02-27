package com.kxjlog.springbootlog.controller;

import com.kxjlog.springbootlog.services.MDCService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @projectName: springbootlog
 * @package: com.kxjlog.springbootlog.controller
 * @className: MDCController
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/10 22:59
 * @version: v2.0
 */
@RestController
@Slf4j
public class MDCController {

    @Autowired
    MDCService mdcService;

    @GetMapping("/MDC")
    public void mdclog(){
        // 设置MDC上下文
        MDC.put("requestID","123");
        MDC.put("uesrID","456");

        // 记录日志，日志会携带MDC信息
        log.info("MDC上下文设置完成");

        // 清除当前线程的MDC信息
        MDC.clear();
    }

    @GetMapping("/threadswitching")
    public void threadswitching(){
        // 设置MDC上下文
        MDC.put("requestID","123");

        // 记录日志，日志会携带MDC信息
        log.info("MDC上下文设置完成,调用MDCService类");
        mdcService.mdcLog();

        // 清除当前线程的MDC信息
        MDC.clear();
    }

}
