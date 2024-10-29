package com.example.demo.DTO;

import com.example.demo.Models.CarRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class CarDTO {
    private String brand;
    private String model;
    private String car_year;
    private String engine;
    private long mileage;
    private List<CarRecord> records;
}
