package com.ericsson.asyncdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    MyTask myTask;
    @GetMapping("/")
    public void contextLoads() throws Exception {
        myTask.doTaskOne();
        myTask.doTaskTwo();
        myTask.doTaskThree();
    }
}


