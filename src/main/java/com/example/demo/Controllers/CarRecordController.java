package com.example.demo.Controllers;

import com.example.demo.Models.CarRecord;
import com.example.demo.Services.CarRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarRecordController {
    private final CarRecordService carRecordService;

    @GetMapping("/records/all")
    public ResponseEntity<List<CarRecord>> getAllCarRecords(){
        List<CarRecord> records = carRecordService.getAllCarRecords();
        return records.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(records);
    }
    @GetMapping("/{carId}/records")
    public ResponseEntity<List<CarRecord>> getCarRecords(@PathVariable long carId){
        List<CarRecord> records = carRecordService.getCarRecordsByCarId(carId);
        return records.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(records);
    }
}
