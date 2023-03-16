package co.develhope.First_API_02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactrorialController {
    @GetMapping("/")
    public long factorial(@RequestParam(required = false) Integer n){

            long fact = 1;
            for (int i = 2; i <= n; i++) {
                fact = fact * i;
            }
        return Math.toIntExact(fact);
    }
}
