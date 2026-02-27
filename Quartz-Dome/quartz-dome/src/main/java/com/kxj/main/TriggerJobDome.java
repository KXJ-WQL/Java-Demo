package com.kxj.main;

import com.kxj.jobs.CountJob;
import com.kxj.jobs.TriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/13 22:39
 * @Version 1.0
 */
public class TriggerJobDome {

    public static void main(String[] args) throws SchedulerException {
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();


        JobDetail jobDetail = JobBuilder.newJob(TriggerJob.class)
                .withIdentity("job1", "group1")
                .build();

        //任务开始时间
        Date startdate = new Date();
        startdate.setTime(startdate.getTime()+3000);//开始延迟3秒
        //任务结束时间
        Date enddate = new Date();
        enddate.setTime(enddate.getTime()+5000);//结束延迟5秒


        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(startdate)//设置任务开始时间
                .endAt(enddate)//设置任务结束时间
                .build();

        defaultScheduler.scheduleJob(jobDetail,trigger);

        defaultScheduler.start();

    }
}
