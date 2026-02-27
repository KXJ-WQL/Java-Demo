package com.kxj.main;

import com.kxj.jobs.CountJob;
import com.kxj.jobs.ExecutionJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/13 15:04
 * @Version 1.0
 */
public class CountJobDome {
    public static void main(String[] args) throws SchedulerException {

        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();


        JobDetail jobDetail = JobBuilder.newJob(CountJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("number",0)
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2))
                .build();

        defaultScheduler.scheduleJob(jobDetail,trigger);

        defaultScheduler.start();

    }
}
