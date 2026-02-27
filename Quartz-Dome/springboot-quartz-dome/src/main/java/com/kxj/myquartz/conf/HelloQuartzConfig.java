package com.kxj.myquartz.conf;

import com.kxj.myquartz.jobs.HelloQuartzJobBeanJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author WQL-KXJ
 * @ProjectName springboot-quartz-dome
 * @PackageName com.kxj.myquartz.conf
 * @Date 2022/10/19 15:23
 * @Version 1.0
 */
//@Configuration
public class HelloQuartzConfig {

    private static final String ID = "SUMMERDAY";

    @Bean
    public JobDetail getJobDetail(){

        JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJobBeanJob.class)
                .withIdentity("hellojob", "hellogroup")
                .storeDurably()//设置当没有Trigger关联job时, 是否继续持久化job，默认为true，这个必须设置，因为在bean的创建中有先后顺序
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger getTrigger(){

        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger", "helloTriggerGroup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))
                .build();

        return simpleTrigger;
    }

    @Bean
    public Scheduler getScheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.scheduleJob(getJobDetail(),getTrigger());

        return scheduler;
    }

}
