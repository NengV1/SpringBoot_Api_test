package com.ss.springbootgo.springboot_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class SchedulerConf implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar task) {
        task.setScheduler(Executors.newScheduledThreadPool(3));
    }
}
