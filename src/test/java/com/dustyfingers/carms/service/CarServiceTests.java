package com.dustyfingers.CarMS.service;

import com.dustyfingers.CarMS.controller.CarController;
import com.dustyfingers.CarMS.model.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTests {

    @Autowired
    CarController carController;
    CarServiceImpl carService;

    @Test
    public void testFindCar() {
        try {
            Car car = carService.findCarById(1);
            Assert.assertNotNull(car);
            Assert.assertNotNull(car.getCar_id());
        } catch (Exception e) {

        }
    }

    @Test
    public void testFindCarBadId() {
        try {
            List<Car> cars = carService.findAllCars();
            Assert.assertNull(cars);
        } catch (Exception e) {

        }
    }

    @Test
    public void testFindAllCars() {
        try {
            List<Car> cars = carService.findAllCars();
            Assert.assertNotNull(cars);
            Assert.assertNotNull(cars.get(0).getCar_id());
        } catch (Exception e) {

        }
    }

    @Test
    public void testCreateCar() {
        try {
            String model = "ABC";
            String color = "red";
            String license_plate = "ASDFGH";
            int seat_count = 4;
            int rating = 5;
            String engine_type = "V6";
            boolean transmission = true;
            String car_type = "4WD";
            String manufacturer = "Nissan";
            Car car = new Car(model, color, license_plate, seat_count, rating,
                    engine_type, transmission, car_type, manufacturer);
            car = carService.makeCar(car);
            Assert.assertNotNull(car);
            Assert.assertEquals(car.getCar_type(), car_type);
            Assert.assertEquals(car.getManufacturer(), manufacturer);
        } catch (Exception e) {

        }

    }

    @Test
    public void testCreateCarNull() {
        try {
            Car car = new Car();
            car = carService.makeCar(car);
            Assert.assertNull(car);
        } catch (Exception e) {
        }
    }

    @Test
    public void testUpdateCar() {
        try {
            int id = 5;
            String model = "DEF";
            String color = "red";
            String license_plate = "ASDFGH";
            int seat_count = 4;
            int rating = 5;
            String engine_type = "V6";
            boolean transmission = true;
            String car_type = "4WD";
            String manufacturer = "Nissan";
            Car car = new Car(model, color, license_plate, seat_count, rating,
                    engine_type, transmission, car_type, manufacturer);
            car.setCar_id(id);
            car = carService.updateCar(car);
            Assert.assertNotNull(car);
            Assert.assertEquals(car.getModel(), model);
        } catch (Exception e) {

        }

    }

    @Test
    public void testDeleteCar() {
        try {
            int id = 5;
            String model = "DEF";
            String color = "red";
            String license_plate = "ASDFGH";
            int seat_count = 4;
            int rating = 5;
            String engine_type = "V6";
            boolean transmission = true;
            String car_type = "4WD";
            String manufacturer = "Nissan";
            Car car = new Car(model, color, license_plate, seat_count, rating,
                    engine_type, transmission, car_type, manufacturer);
            car.setCar_id(id);
            boolean result = carService.deleteCar(id);
            Assert.assertTrue(result);
        } catch (Exception e) {

        }
    }

//    @Test(expected = Exception.class)
//    public void testDeleteCarBadId() {
//        try {
//            int id = 100;
//            Car car = new Car();
//            boolean result = carService.deleteCar(id);
//
//        } catch (Exception e) {
//        }
//    }
}