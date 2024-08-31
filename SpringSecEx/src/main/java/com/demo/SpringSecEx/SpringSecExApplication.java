package com.demo.SpringSecEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecExApplication.class, args);
	}

}


// as first step we have to generate token in JWTFilter and
// the one responsible for same is
// securityConfig we have AuthenticationManager
// which inturn goes to UserController, were we created login
// which have a verify function (in UserService) using UsernamePasswordAuthentication filter
// where using that filter the user is verified and we are generating the token
// in token generation, we are building token with help of claims, signing gets, subj, issuedat, expiratn etc...
// (SecurityConfig -> http...) -> so next time when we send request we r sending token
// so since we r sending new request, we ask them not to go for username and password
// instead go for jwtfilter
// in jwtfilter -> get token from user or get request
// check if token is empty or not starting with bearer, if it is there get username, token and data from database based on wht username is passing
// and verify if those match or not
//if it is matching, validate token create new authentication object and set that in context
// to validate token we have to extract username, we have to extract claim, and to extract claim we to extract lot of other steps tooo...
