package co.develhope.Deploy_02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ThreadLocalRandom;
@RestController
public class BasicController {
    @GetMapping("/")
    public Integer numberIntSumRandom(){
        int randomNum1 = ThreadLocalRandom.current().nextInt(0,10);
        int randomNum2 = ThreadLocalRandom.current().nextInt(0,10);
        return randomNum1+randomNum2;
    }
}
