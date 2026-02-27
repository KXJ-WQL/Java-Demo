package com.kxj.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.jobs
 * @Date 2022/10/14 15:09
 * @Version 1.0
 */
public class SimpleTriggerJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateformat = simpleDateFormat.format(date);
        
        System.out.println(dateformat+"--数据库备份！！");
    }
}
