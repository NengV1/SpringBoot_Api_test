package com.ss.springbootgo.springboot_test.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Log4j2
@EnableAsync
@Configuration
public class AsyncConf implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setQueueCapacity(100);
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("Async-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

//        if(numberOfThreads < corePoolSize)
//            create new thread & run new task
//        else if(numberOfThreads >= corePoolSize)
//            if(queue is not full)
//                put task into queue
//            else if(queue is full)
//                if(numberOfThreads < maxPoolSize)
//                    create new thread & run new task
//                else if(numberOfThreads >= maxPoolSize)
//                    reject task


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error("AsyncMethod::{}({})", method.getName(), params);
            log.error("Exception::{}", ex.getMessage());
            // save exception information to queue or database for retry
        };
    }

}
