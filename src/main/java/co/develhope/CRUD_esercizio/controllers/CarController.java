package co.develhope.CRUD_esercizio.controllers;

import co.develhope.CRUD_esercizio.entities.Car;
import co.develhope.CRUD_esercizio.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @PostMapping
    public Car createNewCar(@RequestBody Car car){
        Car newCar=carRepository.saveAndFlush(car);
        return newCar;
    }
    @GetMapping
    public List<Car> getAllCars(){
        List<Car> allCarsList=carRepository.findAll();
        return allCarsList;
    }
    @GetMapping("/{id}")
    public Optional<Car> getSingleCar(@PathVariable Long id){
        if(carRepository.existsById(id)){
            Optional<Car> singleCar=carRepository.findById(id);
            return singleCar;
        }else{return null;}
    }
    @PutMapping("/{id}")
    public Car editCarType(@RequestParam String type,@PathVariable Long id){
        if(carRepository.existsById(id)){
        Car editedCar=carRepository.getReferenceById(id);
        editedCar.setType(type);
        return carRepository.saveAndFlush(editedCar);}else{return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteSingleCarById(@PathVariable Long id){
        carRepository.deleteById(id);
    }
}
