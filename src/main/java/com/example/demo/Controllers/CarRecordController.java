package com.example.demo.Controllers;

import com.example.demo.Models.Car;
import com.example.demo.Models.CarRecord;
import com.example.demo.Services.CarRecordService;
import com.example.demo.Services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars/{carID}/records")
public class CarRecordController {
    private final CarRecordService carRecordService;
    private final CarService carService;

    @GetMapping()
    public List<CarRecord> getCarRecords(@PathVariable long carID){
        System.out.println("getCarRecords()");
        return carRecordService.getCarRecordsByCarId(carID);
    }
    @PostMapping()
    public CarRecord createCarRecord(@RequestBody CarRecord carRecord, @PathVariable long carID){
        System.out.println("createCarREcord dla id= " + carID);
        Optional<Car> car = carService.getCar(carID);
        if (car.isPresent()){
            carRecord.setCar(car.get());
        } else {
            carRecord.setCar(new Car());
        }
        return carRecordService.addCarRecord(carRecord);
    }
    @GetMapping("/{recordID}")
    public ResponseEntity<CarRecord> getCarRecord(long recordID){
        Optional<CarRecord> carRecord =carRecordService.getCarRecord(recordID);
        return carRecord.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/{recordID}")
    public ResponseEntity<CarRecord> updateCarRecord(@PathVariable long recordID, @RequestBody CarRecord updateCarRecord){
        Optional<CarRecord> carRecord = carRecordService.updateCarRecord(recordID, updateCarRecord);
        return carRecord.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{recordID}")
    public ResponseEntity<CarRecord> deleteCarRecord(@PathVariable long recordID){
        if (carRecordService.deleteCarRecord(recordID)){
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();
    }
}
