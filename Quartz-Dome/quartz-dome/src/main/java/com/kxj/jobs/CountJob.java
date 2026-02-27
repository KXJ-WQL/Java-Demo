package com.kxj.jobs;

import org.quartz.*;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.jobs
 * @Date 2022/10/13 15:03
 * @Version 1.0
 */
@PersistJobDataAfterExecution
public class CountJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap mergedJobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Integer number = (Integer) mergedJobDataMap.get("number");
        number=number+1;
        System.out.println(number);
        jobExecutionContext.getJobDetail().getJobDataMap().put("number",number);
    }

}
