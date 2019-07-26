package com.dustyfingers.CarMS.service;

import com.dustyfingers.CarMS.dao.AuditRepository;
import com.dustyfingers.CarMS.dao.CarRepository;
import com.dustyfingers.CarMS.model.Audit;
import com.dustyfingers.CarMS.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class CarServiceImpl {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AuditRepository auditRepository;

    Car makeCar(Car car) throws Exception {
        try {
            car = carRepository.save(car);
            if (car == null) {
                throw new Exception("car not created");
            }
            // create audit
            String createdBy = "ADMIN";
            LocalDate dateCreated = LocalDate.now();
            boolean deleted = false;
            String description = "created car";
            Audit audit = new Audit(createdBy, dateCreated, deleted, description);
            audit = auditRepository.save(audit);
            if (audit == null) {
                throw new Exception("audit not created");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return car;
    }

    Car findCarById(int id) throws SQLException {
        return carRepository.findById(id)
                .orElseThrow(() -> new SQLException("car not found"));
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
        try {
            // update car
            car = carRepository.save(car);
            if (car == null) {
                throw new Exception("car not updated");
            }
            // create audit
            String createdBy = "ADMIN";
            LocalDate dateCreated = LocalDate.now();
            boolean deleted = false;
            String description = "updated car";
            Audit audit = new Audit(createdBy, dateCreated, deleted, description);
            audit = auditRepository.save(audit);
            if (audit == null) {
                throw new Exception("car not created");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return car;
    }

    boolean deleteCar(int id) throws Exception {
        boolean isDeleted = false;
        try {
            // find car to delete
            Car carToDelete = this.findCarById(id);
            // delete and check isn't there anymore as this JPA method has a void return
            carRepository.delete(carToDelete);
            carToDelete = this.findCarById(id); // throws exception
            // create audit
            String createdBy = "ADMIN";
            LocalDate dateCreated = LocalDate.now();
            boolean deleted = false;
            String description = "deleted car";
            Audit audit = new Audit(createdBy, dateCreated, deleted, description);
            audit = auditRepository.save(audit);
            if (audit == null) {
                throw new Exception("car not deleted");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }
}
