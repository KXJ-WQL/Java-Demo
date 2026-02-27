package com.kxj.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.listener
 * @Date 2022/10/15 12:17
 * @Version 1.0
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        String ListenerName = this.getClass().getSimpleName();
        //System.out.println("监听器名称："+ListenerName);
        return ListenerName;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("Job即将被执行时调用!!");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("Job即将被执行，但又被TriggerListener否决时调用!!");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("Job被执行之后调用!!");
    }
}
