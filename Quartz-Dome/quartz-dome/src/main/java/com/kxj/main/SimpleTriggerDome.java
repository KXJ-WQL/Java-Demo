package com.kxj.main;

import com.kxj.jobs.CountJob;
import com.kxj.jobs.SimpleTriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/14 15:10
 * @Version 1.0
 */
public class SimpleTriggerDome {

    public static void main(String[] args) throws SchedulerException {

        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(SimpleTriggerJob.class)
                .withIdentity("job1", "group1")
                .build();
        //结束时间
        Date enddate = new Date();
        enddate.setTime(enddate.getTime()+10000);//当前时间推迟10秒

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .endAt(enddate)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5).withRepeatCount(2))//5秒执行一次，总共3次(从0开始)
                .build();

        defaultScheduler.scheduleJob(jobDetail,trigger);

        defaultScheduler.start();
    }
}
