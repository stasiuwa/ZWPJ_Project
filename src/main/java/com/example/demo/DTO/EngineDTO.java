package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EngineDTO {
    private String engineCode;
    private double capacity;
    private int horsePower;
    private int torque;
}
