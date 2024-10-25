package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String model;
    private String carYear;
    private String edition;

    @OneToOne(mappedBy = "car", fetch = FetchType.LAZY)
    private Engine engine;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<CarRecord> records;

}
