package com.univ;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByPlateNumber(String plateNumber);
}
