package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Engine {
    @Id
    private String engineCode;
    @OneToOne
    private Car car;

    private double capacity;
    private int horsePower;
    private int torque;
}
