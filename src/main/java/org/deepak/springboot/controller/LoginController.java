package org.deepak.springboot.controller;

import org.deepak.springboot.model.User;
import org.deepak.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return loginService.authenticate(user);
    }
}
