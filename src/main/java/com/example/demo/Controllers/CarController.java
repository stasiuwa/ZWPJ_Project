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
        System.out.println(car);
        return carService.addCar(car);
    }
    @GetMapping("/{carID}")
    public ResponseEntity<Car> getCar(@PathVariable long carID){
        System.out.println("carID: " + carID);
        Optional<Car> car = carService.getCar(carID);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{carID}")
    public ResponseEntity<Car> updateCar(@PathVariable long carID, @RequestBody Car updateCar){
        Optional<Car> car = carService.updateCar(carID, updateCar);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{carID}")
    public ResponseEntity<Car> deleteCar(@PathVariable long carID){
        if (carService.deleteCar(carID)){
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();
    }
}
