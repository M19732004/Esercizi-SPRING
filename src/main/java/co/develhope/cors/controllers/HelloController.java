package co.develhope.cors.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class HelloController {

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:63342/")
    public java.lang.String hello() {
        return "Hello from localhost:8080";
    }
}