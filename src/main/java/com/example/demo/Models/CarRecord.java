package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CarRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private RecordType type;
    private Date date;
    private String description;
    private long mileage;
    private double price;
}
