package com.kxj.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.listener
 * @Date 2022/10/15 12:37
 * @Version 1.0
 */
public class MyTriggenListener implements TriggerListener {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("Trigger被触发！！");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("Trigger没有被触发！！");
        return true;//返回true JOB不会被执行
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("Trigger错过触发！！");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        System.out.println("Trigger完成之后被触发！！");
    }
}
