package com.kxj.jobs;

import org.quartz.*;

/*
 * @Author WQL-KXJ
 * @ProjectName quartz-dome
 * @PackageName com.kxj.jobs
 * @Date 2022/10/13 11:28
 * @Version 1.0
 */
public class ExecutionJob implements Job {

    private String kxj;

    public void setKxj(String kxj) {
        this.kxj = kxj;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取任务实例
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println("任务类名："+jobDetail.getJobClass().getSimpleName());//类名
        System.out.println("任务组名："+jobDetail.getKey().getGroup());//组名
        System.out.println("任务名称："+jobDetail.getKey().getName());//任务名

        //获取触发器
        Trigger trigger = jobExecutionContext.getTrigger();

        //获取调度器
        Scheduler scheduler = jobExecutionContext.getScheduler();

        //获取时间
        System.out.println("当前任执行时间："+jobExecutionContext.getFireTime());
        System.out.println("下一次任务执行时间："+jobExecutionContext.getNextFireTime());
        System.out.println("任务运行时间："+jobExecutionContext.getJobRunTime());

        //直接操作上下文数据映射的值
        jobExecutionContext.put("qt","晴天");
        System.out.println(jobExecutionContext.get("qt"));

        //获取JobDataMap
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println(mergedJobDataMap.get("kxj"));


    }
}
