package com.ericsson.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author fy
 * @date 2019/4/15
 * @time 下午9:12
 * @discription
 **/
@RestController
public class HelloWebFluxController {

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("fy");
        user.setDesc("欢迎关注我...");
        return Mono.just(user);
    }


}

