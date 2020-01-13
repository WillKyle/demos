package com.will.lucifer.controller;

import com.will.lucifer.vo.User1;
import com.will.lucifer.vo.User2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BuilderController {

    @GetMapping("/user1")
    public User1 user1(){
        User1 user1 = new User1.User1Builder().id(1).name("zhangsan").age(15).gender("male").build();
        log.info(user1.toString());
        User1 user2 = new User1.User1Builder(user1).id(2).name("lisi").gender("female").build();
        log.info(user2.toString());
        return user2;
    }

    @GetMapping("/user2")
    public User2 user2(){
        User2 user1 = User2.builder().id(1).name("zhangsan").age(15).gender("male").build();
        log.info(user1.toString());
        User2 user2 = user1.toBuilder().id(2).name("lisi").gender("female").build();
        log.info(user2.toString());
        return user2;
    }
}
