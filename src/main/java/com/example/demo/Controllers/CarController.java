package com.example.demo.Controllers;

import com.example.demo.Models.Car;
import com.example.demo.Models.CarRecord;
import com.example.demo.Services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        System.out.println("getAllCars()");
        return carService.getAllCars();
    }

    @PostMapping()
    public Car createCar(@RequestBody Car car){
        System.out.println("createCar()");
        return carService.addCar(car);
    }
    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable long carId){
        Optional<Car> car = carService.getCar(carId);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable long carId, @RequestBody Car updateCar){
        Optional<Car> car = carService.updateCar(carId, updateCar);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<Car> deleteCar(@PathVariable long carId){
        if (carService.deleteCar(carId)){
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();
    }
}
