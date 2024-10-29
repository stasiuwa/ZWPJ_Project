package com.example.demo.Services;

import com.example.demo.Models.CarRecord;
import com.example.demo.Repositories.CarRecordRepository;
import com.example.demo.Repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<CarRecord> getCarRecord(long carRecordId) {
        return carRecordRepository.findById(carRecordId);
    }
    public CarRecord addCarRecord(CarRecord carRecord){
        return carRecordRepository.save(carRecord);
    }
    public Optional<CarRecord> updateCarRecord(long carRecordId, CarRecord newCarRecord){
        return carRecordRepository.findById(carRecordId).map(existingRecord -> {
            existingRecord.setCar(newCarRecord.getCar());
            existingRecord.setType(newCarRecord.getType());
            existingRecord.setDate(newCarRecord.getDate());
            existingRecord.setDetails(newCarRecord.getDetails());
            existingRecord.setMileage(newCarRecord.getMileage());
            existingRecord.setPrice(newCarRecord.getPrice());
            return carRecordRepository.save(existingRecord);
        });
    }
    public boolean deleteCarRecord(long carRecordId){
        if (carRecordRepository.existsById(carRecordId)){
            carRecordRepository.deleteById(carRecordId);
            return true;
        } else return false;
    }
}
