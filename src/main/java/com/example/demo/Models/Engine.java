package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Engine {
    @Id
    private String engineCode;
    private double capacity;
    private int horsePower;
    private int torque;
}
