package com.ss.springbootgo.springboot_test.service;

import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;

@Log4j2
public abstract class CommonService {

    @PostConstruct
    protected void postConstruct() {

        log.info(getClass().getSimpleName() + " : Initialized()");
    }

}
