package co.develhope.API_Custom.Queries_02.controllers;

import co.develhope.API_Custom.Queries_02.entities.Flight;
import co.develhope.API_Custom.Queries_02.entities.Status;
import co.develhope.API_Custom.Queries_02.repositories.FlightRepository;
import co.develhope.API_Custom.Queries_02.services.RandomStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController {
@Autowired
private FlightRepository flightRepository;
@Autowired
private RandomStringService randomStringService;
    @PostMapping("/flightsCreation")
        public ResponseEntity flightsCreation(@RequestParam(required = false) Integer numberOfFlights){
            if(numberOfFlights==null){
                numberOfFlights=100;};
            for(int i=1;i<=numberOfFlights;i++){
                Flight flight=new Flight(randomStringService.randomString(),randomStringService.randomString(),randomStringService.randomString(),Status.randomStatus());
                flightRepository.saveAndFlush(flight);
            }
        return ResponseEntity.ok("Created flights");
    }
    @GetMapping("/getAllFlights")
    public List<Flight> getAllFlights(){
        List<Flight> flightList=flightRepository.findAll();
        return flightList;
    };
    @GetMapping("/getAllFlightsPageSort")
    public Page<Flight> getAllFlightsPageSort(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        Sort sort=Sort.by(new Sort.Order(Sort.Direction.ASC,"fromAirport"));
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Flight> allFlights=flightRepository.findAll(pageable);
        return allFlights;
    }
@GetMapping("/getAllFlightsByP1P2")
    public List<Flight> getAllFlightsByP1P2(@RequestParam(required = false) Status P1, @RequestParam(required = false) Status P2){
            List<Flight> flightsByP1P2List=flightRepository.findAll().stream().filter(flight -> (flight.getStatus()==P1||flight.getStatus()==P2)).collect(Collectors.toList());
            return flightsByP1P2List;
}
}
