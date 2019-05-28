package com.ss.springbootgo.springboot_test.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Log4j2
public class OrderService {

    @PostConstruct
    private void init(){
        System.out.println(this.getClass().getSimpleName()+":Init()");
    }
}
