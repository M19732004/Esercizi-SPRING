package co.develhope.First_API_03.contoller;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StringController {
    @GetMapping("/")
    public String strings(@RequestParam String string1,@RequestParam String string2){

        return string1+" "+string2;
    }
/*
    @GetMapping(value="/echo/{string1},{string2}")
    public String postRoute(@RequestBody User user){

        return toString();
    }
*/
}
