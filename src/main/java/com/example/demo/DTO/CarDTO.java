package com.example.demo.DTO;

import com.example.demo.Models.CarRecord;
import com.example.demo.Models.Engine;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CarDTO {
    private String brand;
    private String model;
    private String carYear;
    private String edition;
    private Engine engine;
    private List<CarRecord> records;
}
