package com.kxj.main;

import com.kxj.jobs.CornTriggerJob;
import com.kxj.jobs.CountJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/14 16:58
 * @Version 1.0
 */
public class CornTriggerDome {
    public static void main(String[] args) throws SchedulerException {

        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(CornTriggerJob.class)
                .withIdentity("job1", "group1")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * 14 10 ?"))//10月14号每5秒执行
                .build();

        defaultScheduler.scheduleJob(jobDetail, trigger);

        defaultScheduler.start();
    }
}
