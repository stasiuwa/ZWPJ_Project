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

    public String brand;
    public String model;
    public String carYear;
    public String edition;

    @OneToOne(mappedBy = "car", fetch = FetchType.LAZY)
    public Engine engine;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    public List<CarRecord> records;

}
