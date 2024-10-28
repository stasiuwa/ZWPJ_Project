package com.example.demo.Controllers;

import com.example.demo.Models.CarRecord;
import com.example.demo.Services.CarRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarRecordController {
    private final CarRecordService carRecordService;

    @GetMapping("/cars/records/all")
    public ResponseEntity<List<CarRecord>> getAllCarRecords(){
        System.out.println("getAllCarRecords()");
        List<CarRecord> records = carRecordService.getAllCarRecords();
        return records.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(records);
    }
    @GetMapping("/cars/{carId}/records")
    public ResponseEntity<List<CarRecord>> getCarRecords(@PathVariable long carId){
        System.out.println("getCarRecords()");
        List<CarRecord> records = carRecordService.getCarRecordsByCarId(carId);
        return records.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(records);
    }
}
