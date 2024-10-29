package com.example.demo.DTO;

import com.example.demo.Models.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CarRecordDTO {
    private String type;
    private Date date;
    private String details;
    private long mileage;
    private double price;
    private Car car;
}
