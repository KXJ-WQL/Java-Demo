package com.kxj.main;

import com.kxj.jobs.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.main
 * @Date 2022/10/12 16:35
 * @Version 1.0
 */
public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {

        //1，调度器(Scheduler)，从工厂中获取调度实例
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        //2，任务实例(JobDetail)
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)//加载任务类
                .withIdentity("job1", "group1")//参数1：任务的名称 参数2：任务组的名称
                .build();
        //获取任务名
        System.out.println("任务名："+jobDetail.getKey().getName());
        //获取任务组
        System.out.println("任务组："+jobDetail.getKey().getGroup());
        //获取任务类(class类型)
        System.out.println("任务类："+jobDetail.getKey().getClass());
        //获取JobDataMap
        System.out.println("任务存储数据map："+jobDetail.getJobDataMap());
        //3，触发器(Trigger)
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")//参数1：触发器名称 参数2：触发器组名称
                .startNow()//启动后立即执行触发器
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(7))//每七秒执行重复执行一次
                .build();

        //Scheduler调度器关联任务实例和触发器，保证触发器定义的条件执行任务实例
        defaultScheduler.scheduleJob(jobDetail,trigger);

        //启动调度器
        defaultScheduler.start();
    }

}
