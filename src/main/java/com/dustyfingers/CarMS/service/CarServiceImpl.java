package com.dustyfingers.CarMS.service;

import com.dustyfingers.CarMS.model.Car;

import java.util.Arrays;
import java.util.List;

public class CarServiceImpl {
    Car makeCar(Car car) {
        return new Car();
    }

    Car findCarById(int id) {
        return new Car();
    }

    List<Car> findAllCars() {
        return Arrays.asList(new Car());
    }

    Car updateCar(Car car) {
        return new Car();
    }

    boolean deleteCar(int id) {
        return false;
    }
}
