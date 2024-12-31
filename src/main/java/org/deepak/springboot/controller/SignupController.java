package org.deepak.springboot.controller;

import org.deepak.springboot.model.User;
import org.deepak.springboot.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    SignupService signupService;

    @PostMapping("/signup")
    public User register(@RequestBody User user){
        return signupService.register(user);
    }
}
