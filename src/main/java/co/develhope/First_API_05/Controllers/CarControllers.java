package co.develhope.First_API_05.Controllers;

import co.develhope.First_API_05.DTO.CarDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CarControllers {
    @GetMapping("/")
    public String get(String id,String modelCar, Double price){
        return "Ciao ,sono il get "+id+" modelCar "+modelCar+" ,price ="+price;
    }
    @PostMapping("/")
    public String postCar(@RequestBody(required = false) CarDTO carDTO,
                          HttpServletRequest request, HttpServletResponse response){
        return carDTO.toString();
    }
    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody CarDTO carDTO) {
        // persisting the user
        return ResponseEntity.ok("User is valid");
    }
}
