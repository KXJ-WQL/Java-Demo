package com.kxj.jobs;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.jobs
 * @Date 2022/10/13 22:39
 * @Version 1.0
 */
public class TriggerJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //当前时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd MM:mm:ss");
        System.out.println("任务当前时间"+simpleDateFormat.format(date));

        //获取Trigger
        Trigger trigger = jobExecutionContext.getTrigger();
        //通过Trigger获取jobKey
        JobKey jobKey = trigger.getJobKey();
        System.out.println(jobKey.getName());//获取job的名称
        System.out.println(jobKey.getGroup());//获取job的组名

        //任务开始时间
        System.out.println("任务开始时间"+simpleDateFormat.format(trigger.getStartTime()));

        //任务结束时间
        System.out.println("任务结束时间"+simpleDateFormat.format(trigger.getEndTime()));
    }
}
