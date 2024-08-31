package com.demo.SpringSecEx.controller;

import com.demo.SpringSecEx.domain.Users;
import com.demo.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        //System.out.println(user); // to verify user login or not...to print in console
        //return "Success";
        return service.verify(user);
    }
}
