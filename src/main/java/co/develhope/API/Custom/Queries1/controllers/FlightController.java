package co.develhope.API.Custom.Queries1.controllers;

import co.develhope.API.Custom.Queries1.entities.Flight;
import co.develhope.API.Custom.Queries1.entities.Status;
import co.develhope.API.Custom.Queries1.repositories.FlightRepository;
import co.develhope.API.Custom.Queries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    FlightService flightService;
    @PostMapping("/Provisioning")
    public ResponseEntity provisioning(){
       flightService.provisioning();
        return ResponseEntity.ok("50 flights created");
    }
    @GetMapping("/flight")
    public ResponseEntity getAllFlights(){
        return ResponseEntity.ok( flightService.getAllFlight());
    }


}
