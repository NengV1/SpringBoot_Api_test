package com.ss.springbootgo.springboot_test.config;


import com.ss.springbootgo.springboot_test.exception.MandatoryException;
import com.ss.springbootgo.springboot_test.exception.OptionalException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

@EnableRetry
@Configuration
public class RetryConf {
    @Bean
    public RetryTemplate build() {
        RetryTemplate template = new RetryTemplate();
        Map<Class<? extends Throwable>, Boolean> exceptions = new HashMap<>();
        exceptions.put(MandatoryException.class, true);
        exceptions.put(OptionalException.class, false);
        template.setRetryPolicy(new SimpleRetryPolicy(3, exceptions));

        ExponentialBackOffPolicy exponential = new ExponentialBackOffPolicy();
        exponential.setMultiplier(2);
        exponential.setInitialInterval(1000); // 1000ms = 1s
        exponential.setMaxInterval(60000); // 60000ms = 60s
        template.setBackOffPolicy(exponential);

//        FixedBackOffPolicy fixed = new FixedBackOffPolicy();
//        fixed.setBackOffPeriod(1000);  // 1000ms = 1s
//        template.setBackOffPolicy(fixed);

        return template;
    }


}
