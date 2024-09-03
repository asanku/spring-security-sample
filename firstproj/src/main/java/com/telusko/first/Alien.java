package com.telusko.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // implies this class is responsible to create spring object of Alien in main class
public class Alien {

    @Autowired //means laptop obj will be created by spring
    Laptop lap;
    public void code(){
        lap.compile();
    }
}
