package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Engine {
    @Id
    public String engineCode;
    public double capacity;
    public int horsePower;
    public int torque;
}
