package com.kxj.main;

import com.kxj.jobs.MyJobListerJob;
import com.kxj.jobs.MyTriggerListenerJob;
import com.kxj.listener.MyJobListener;
import com.kxj.listener.MyTriggenListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/15 12:39
 * @Version 1.0
 */
public class MyTriggerListenerDome {

    public static void main(String[] args) throws SchedulerException {
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(MyTriggerListenerJob.class)
                .withIdentity("job1", "group1")
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5).withRepeatCount(2))//5秒执行一次，总共3次(从0开始)
                .build();

        defaultScheduler.scheduleJob(jobDetail,trigger);

        //创建注册一个全局的Job监听器
        defaultScheduler.getListenerManager().addTriggerListener(new MyTriggenListener(), EverythingMatcher.allTriggers());

        //创建注册一个局部的Job监听器,指定任务Job
        //defaultScheduler.getListenerManager().addTriggerListener(new MyTriggenListener(), KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1","group1")));

        defaultScheduler.start();
    }
}
