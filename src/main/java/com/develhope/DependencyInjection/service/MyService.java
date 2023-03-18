package com.develhope.DependencyInjection.service;

import com.develhope.DependencyInjection.components.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private MyComponent myComponent;
    public MyService(MyComponent myComponent){
        System.out.println("MyService constructor has been called");
        this.myComponent=myComponent;
    }
    public String getName(){
        System.out.println("MyService getname constructor has been called");
        return myComponent.getMyComponentName();

    }





}
