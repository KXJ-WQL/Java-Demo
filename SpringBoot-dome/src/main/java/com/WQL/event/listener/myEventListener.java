package com.WQL.event.listener;

import com.WQL.event.eventbean.myEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @projectName: SpringBoot-dome
 * @package: com.WQL.event.listener
 * @className: myEventListener
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/20 0:35
 * @version: v1.0
 */
@Component
public class myEventListener implements ApplicationListener<myEvent> {
    @Override
    public void onApplicationEvent(myEvent myEvent) {
        System.out.println("自定义事件类被触发---"+myEvent.getMessage());
    }
}
