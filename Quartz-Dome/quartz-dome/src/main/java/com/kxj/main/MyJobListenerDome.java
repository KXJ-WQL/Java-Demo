package com.kxj.main;

import com.kxj.jobs.MyJobListerJob;
import com.kxj.jobs.SimpleTriggerJob;
import com.kxj.listener.MyJobListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

import java.util.Date;
import java.util.EventListener;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/15 12:17
 * @Version 1.0
 */
public class MyJobListenerDome {
    public static void main(String[] args) throws SchedulerException {
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(MyJobListerJob.class)
                .withIdentity("job1", "group1")
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5).withRepeatCount(2))//5秒执行一次，总共3次(从0开始)
                .build();

        defaultScheduler.scheduleJob(jobDetail,trigger);

        //创建注册一个全局的Job监听器
        defaultScheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());

        //创建注册一个局部的Job监听器,指定任务Job
        //defaultScheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job1","group1")));

        defaultScheduler.start();
    }
}
