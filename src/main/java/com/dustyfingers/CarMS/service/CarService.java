package com.dustyfingers.CarMS.service;

import com.dustyfingers.CarMS.model.Car;

import java.util.List;

public interface CarService {

    Car makeCar(Car car);

    Car findCarById(int id);

    List<Car> findAllCars();

    Car updateCar(Car car);

    boolean deleteCar(int id);
}
