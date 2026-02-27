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
 * @Date 2022/10/14 16:58
 * @Version 1.0
 */
public class CornTriggerJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前日期和数据
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateformat = simpleDateFormat.format(date);

        //执行任务
        System.out.println(dateformat+"--数据库备份！！");
    }
}
