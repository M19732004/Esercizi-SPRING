package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MathController {
    @Autowired
    private ArithmeticOperation arithmeticOperation;
    @GetMapping("/math")
    public String welcomeMathMsg(){
        return "welcome Math";
    }
    @GetMapping("/math/{n1},{n2}")
    public String division_info(@PathVariable int n1  , @PathVariable int  n2){
        System.out.println(n1+"/"+n2);
    return"division_info " +n1+"/"+n2;
    }
    @GetMapping("/math/{n1},{n2}")
    public long muliplication(@PathVariable int n1  ,@PathVariable int  n2){
        System.out.println(muliplication(n1,n2));
        return muliplication(n1,n2);
    }
    @Bean
    public double divisionMethod(int n1, int n2){
        return n1/n2;
    }

}