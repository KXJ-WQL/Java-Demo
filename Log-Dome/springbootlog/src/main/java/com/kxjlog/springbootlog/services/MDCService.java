package com.kxjlog.springbootlog.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @projectName: springbootlog
 * @package: com.kxjlog.springbootlog.services
 * @className: MDCService
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/11 10:51
 * @version: v2.0
 */
@Service
@Slf4j
public class MDCService {

    @Async("MDCThreadPool")
    public void mdcLog(){
        log.error("MDCService被调用- {}", MDC.get("requestID"));
    }

}
