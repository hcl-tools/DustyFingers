package com.dustyfingers.CarMS.service;

import com.dustyfingers.CarMS.dao.AuditRepository;
import com.dustyfingers.CarMS.dao.CarRepository;
import com.dustyfingers.CarMS.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarServiceImpl {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AuditRepository auditRepository;

    Car makeCar(Car car) throws Exception {
        return carRepository.save(car);
    }

    Car findCarById(int id) throws Exception {
        return carRepository.findById(id)
                .orElseThrow(() -> new Exception("Car not found"));
    }

    List<Car> findAllCars() {
        Iterable<Car> cars = carRepository.findAll();
        if(cars instanceof List) {
            return (List<Car>) cars;
        }
        ArrayList<Car> list = new ArrayList<>();
        if(cars != null) {
            for(Car c: cars) {
                list.add(c);
            }
        }
        return list;
    }

    Car updateCar(Car car) throws Exception {
        return carRepository.save(car);
    }

    boolean deleteCar(int id) throws Exception {
        return false;
    }
}
