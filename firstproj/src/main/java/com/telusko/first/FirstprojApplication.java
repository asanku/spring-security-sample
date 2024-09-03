package com.telusko.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstprojApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(FirstprojApplication.class, args);

        //Alien obj = new Alien(); if we give it like this it means that we r the ones initiating the obj
        Alien obj = context.getBean(Alien.class); // getBean belongs to an interface called Application Context
        // so if we need to call getBean, then we need an object of application context
        obj.code();
    }

}
