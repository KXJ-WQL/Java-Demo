package com.WQL.event.eventbean;

import org.springframework.context.ApplicationEvent;

/**
 * @projectName: SpringBoot-dome
 * @package: com.WQL.event.eventbean
 * @className: myevent
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/20 0:30
 * @version: v1.0
 */
public class myEvent extends ApplicationEvent{

    private String message;

    public myEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
