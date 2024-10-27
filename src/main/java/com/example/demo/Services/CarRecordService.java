package com.example.demo.Services;

import com.example.demo.Models.CarRecord;
import com.example.demo.Repositories.CarRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarRecordService {
    private final CarRecordRepository carRecordRepository;

    public List<CarRecord> getCarRecordsByCarId(long carId) {
        return carRecordRepository.findByCarId(carId);
    }
    public List<CarRecord> getAllCarRecords(){
        return carRecordRepository.findAll();
    }

}
