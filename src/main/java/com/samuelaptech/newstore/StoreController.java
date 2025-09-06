package com.samuelaptech.newstore;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @RequestMapping("/")
    public String newHome(){
        return "This is a new spring project edited";
    }

}
