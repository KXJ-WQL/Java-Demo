package com.WQL.event.listener;

import com.WQL.event.eventbean.myEvent;
import org.springframework.context.ApplicationListener;

/**
 * @projectName: SpringBoot-dome
 * @package: com.WQL.event.listener
 * @className: myFactoriesEventListener
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/20 1:06
 * @version: v1.0
 */
public class myFactoriesEventListener implements ApplicationListener<myEvent> {
    @Override
    public void onApplicationEvent(myEvent myEvent) {
        System.out.println("实现ApplicationListener+自动化配置文件--"+myEvent.getMessage());
    }
}
