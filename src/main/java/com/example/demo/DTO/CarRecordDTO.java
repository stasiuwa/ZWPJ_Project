package com.example.demo.DTO;

import com.example.demo.Models.RecordType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CarRecordDTO {
    private RecordType type;
    private Date date;
    private String description;
    private long mileage;
    private double price;
}
