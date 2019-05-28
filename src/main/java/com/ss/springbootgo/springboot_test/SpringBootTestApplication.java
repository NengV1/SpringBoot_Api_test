package com.ss.springbootgo.springboot_test;







import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootTestApplication  {

//    private final ProductService service;
//    private final CacheConf conf;
//    private final SimpleCacheManager manager;

//   @Autowired
//    private CustomProperty prop;
 //       @Qualifier("beanPlus")
   //     private Calculator cal;

        public static void main(String[] args) {
            System.err.close();
            SpringApplication.run(SpringBootTestApplication.class, args);
        }

//        @Bean
//        public CommandLineRunner commandLineRunner(ApplicationContext context) {
//            return s -> System.out.println(cal.calculate(5, 4));
//
//    }





}


