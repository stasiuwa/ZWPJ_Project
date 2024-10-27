package com.example.demo.Services;

import com.example.demo.Models.Car;
import com.example.demo.Repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public Optional<Car> getCar(long carId){
        return carRepository.findById(carId);
    }
    public Car addCar(Car car){
        return carRepository.save(car);
    }
    public Optional<Car> updateCar(long carId, Car newCar){
        return carRepository.findById(carId).map(existingCar -> {
            existingCar.setBrand(newCar.getBrand());
            existingCar.setModel(newCar.getModel());
            existingCar.setEngine(newCar.getEngine());
            existingCar.setEdition(newCar.getEdition());
            existingCar.setCarYear(newCar.getCarYear());
            return carRepository.save(existingCar);
        });
    }
    public boolean deleteCar(long carId){
        if (carRepository.existsById(carId)){
            carRepository.deleteById(carId);
            return true;
        } else return false;
    }
}
