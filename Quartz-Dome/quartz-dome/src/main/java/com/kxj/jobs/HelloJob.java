package com.kxj.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.jobs
 * @Date 2022/10/12 16:17
 * @Version 1.0
 */
public class HelloJob implements Job {

    public HelloJob() {
        System.out.println("HelloJob被创建");
    }

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
