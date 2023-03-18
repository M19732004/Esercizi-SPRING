package com.develhope.DependencyInjection.components;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private String myComponentName;


    public MyComponent(){
        System.out.println("MyComponent constructor has been called");
        this.myComponentName ="Maria";
    }

    public String getMyComponentName() {
        System.out.println("MyComponent getMyComponent constructor has been called");
        return myComponentName;
    }

    public void setMyComponentName(String myComponentName) {
        System.out.println("MyComponent setMyComponent constructor has been called");
        this.myComponentName = myComponentName;
    }
    public String toString(){
        System.out.println("MyComponent toString constructor has been called");
        return String.format("MyComponentName is %S",myComponentName);
    }
}
