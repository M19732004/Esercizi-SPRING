package com.example.Deploy_Environments_Variables_01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController{
    @Autowired
    private Environment environment;
    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome "+environment.getProperty("myCustomVarTree.devName")+environment.getProperty("myCustomVarTree.authCode");
    }
}