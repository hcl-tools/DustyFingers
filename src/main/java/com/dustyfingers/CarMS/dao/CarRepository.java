package com.dustyfingers.CarMS.dao;

import com.dustyfingers.CarMS.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
