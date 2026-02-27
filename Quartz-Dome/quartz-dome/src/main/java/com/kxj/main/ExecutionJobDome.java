package com.kxj.main;

import com.kxj.jobs.ExecutionJob;
import com.kxj.jobs.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/13 11:51
 * @Version 1.0
 */
public class ExecutionJobDome {

    public static void main(String[] args) throws SchedulerException {

        //1，调度器(Scheduler)，从工厂中获取调度实例
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        //jobDataMap
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("kxj","空想家");

        //2，任务实例(JobDetail)
        JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class)//加载任务类
                .withIdentity("job1", "group1")//参数1：任务的名称 参数2：任务组的名称
                .usingJobData(jobDataMap)
                .build();

        //3，触发器(Trigger)
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")//参数1：触发器名称 参数2：触发器组名称
                .startNow()//启动后立即执行触发器
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2))//每2秒执行重复执行一次
                .build();

        //Scheduler调度器关联任务实例和触发器，保证触发器定义的条件执行任务实例
        defaultScheduler.scheduleJob(jobDetail,trigger);

        //启动调度器
        defaultScheduler.start();

    }
}
