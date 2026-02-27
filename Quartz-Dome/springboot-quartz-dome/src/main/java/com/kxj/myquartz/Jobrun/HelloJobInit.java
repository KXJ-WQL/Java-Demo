package com.kxj.myquartz.Jobrun;

import com.kxj.myquartz.jobs.HelloJob;
import com.kxj.myquartz.jobs.HelloQuartzJobBeanJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/*
 * @Author WQL-KXJ
 * @ProjectName springboot-quartz-dome
 * @PackageName com.kxj.myquartz.Jobrun
 * @Date 2022/10/19 16:11
 * @Version 1.0
 */
@Component
public class HelloJobInit implements ApplicationRunner {

    @Autowired
    Scheduler scheduler;//这个对象必须引入，本地创建不会被调用

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJobBeanJob.class)
                .withIdentity("job1","jobgroup1")
                .storeDurably()
                .build();
        CronScheduleBuilder scheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
        // 创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("01Trigger","01TriggerGroup")
                .startNow() //立即執行一次任務
                .withSchedule(scheduleBuilder)
                .build();
        // 手动将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
