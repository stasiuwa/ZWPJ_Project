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

    public RecordType type;
    public Date date;
    public String description;
    public long mileage;
    public double price;
}
