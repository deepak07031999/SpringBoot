package org.deepak.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/home","/"})
    public static String home(){
        return "Home Page";
    }
}
