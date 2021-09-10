package com.labcloud.tdddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class TddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddDemoApplication.class, args);
    }

}

