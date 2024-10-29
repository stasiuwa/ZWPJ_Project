package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String model;
    private String car_year;
    private String engine;
    private long mileage;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<CarRecord> records;

}
