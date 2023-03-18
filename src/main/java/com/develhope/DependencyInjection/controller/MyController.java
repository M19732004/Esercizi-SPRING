package com.develhope.DependencyInjection.controller;

import com.develhope.DependencyInjection.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MyController {
  @Autowired
    private MyService service;

    public MyController(MyService service) {
        System.out.println("MyController constructor has been called");
        this.service = service;
    }

    @GetMapping("/getName")
    public String getName() {
        return service.getName();
    }

    @GetMapping("/")
    public String print() {
        System.out.println("MyController  print 'Welcome' constructor has been called");
        return "Welcome";
    }
}





