package com.WQL.event.controll;

import com.WQL.event.eventbean.myEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @projectName: SpringBoot-dome
 * @package: com.WQL.event.controll
 * @className: myEventControll
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/20 0:38
 * @version: v1.0
 */
@RestController
public class myEventControll {

    @Resource
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/event")
    public String eventPublisher(){

        //实例化事件类
        myEvent myEvent = new myEvent(this,"空想家");

        //发布事件
        applicationEventPublisher.publishEvent(myEvent);

        return "事件发布成功";
    }
}
