package com.WQL.event.listener;

import com.WQL.event.eventbean.myEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @projectName: SpringBoot-dome
 * @package: com.WQL.event.listener
 * @className: myAnnotationEventListener
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/20 0:59
 * @version: v1.0
 */
@Component
public class myAnnotationEventListener {

    @EventListener(classes = {myEvent.class})
    public void evt(myEvent myEvent){
        System.out.println("@EventListener+容器注解实现监听器--"+myEvent.getMessage());
    }
}
