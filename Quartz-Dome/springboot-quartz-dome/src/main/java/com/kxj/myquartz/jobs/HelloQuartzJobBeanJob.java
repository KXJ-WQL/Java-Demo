package com.kxj.myquartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName springboot-quartz-dome
 * @PackageName com.kxj.myquartz.jobs
 * @Date 2022/10/19 14:12
 * @Version 1.0
 */
public class HelloQuartzJobBeanJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //打印当前日期和数据
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateformat = simpleDateFormat.format(date);

        //执行任务
        System.out.println(dateformat+"--数据库备份！！");

    }
}
