package co.develhope.First_API01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/")
    public String name(){
        return "Federico";
    }
    @PostMapping("/")
    public String name2(){
        StringBuilder str = new StringBuilder("Federico");
        str.reverse();
        return str.toString();
    }
}
