package com.ss.springbootgo.springboot_test;





import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2
@SpringBootApplication
public class SpringBootTestApplication {


    public static void main(String[] args) {
        System.err.close();
        SpringApplication.run(SpringBootTestApplication.class, args);
log.info("{}","hi");
        // log.info("{} Message","Track");
    }
}
