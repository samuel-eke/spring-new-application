package com.samuelaptech.newstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String newHome(){
        return "This is a new spring project edited";
    }

}

