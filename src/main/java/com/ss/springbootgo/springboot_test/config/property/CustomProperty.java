package com.ss.springbootgo.springboot_test.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("custom")
public class CustomProperty {

    private String name;
    private String email;
    private String tel;


}
