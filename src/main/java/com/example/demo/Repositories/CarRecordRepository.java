package com.example.demo.Repositories;

import com.example.demo.Models.CarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRecordRepository extends JpaRepository<CarRecord, Long> {
    List<CarRecord> findByCarId(long carId);
}
