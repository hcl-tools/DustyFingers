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

    @Test
    public void testFindCar() {
        Car car = carController.getCar(1);
        Assert.assertNotNull(car);
        Assert.assertNotNull(car.getCar_id());
    }

    @Test(expected = Exception.class)
    public void testFindCarBadId() {
        Car car = carController.getCar(-100);
        Assert.assertNull(car);
    }

    @Test
    public void testFindAllCars() {
        List<Car> cars = carController.getAllCars();
        Assert.assertNotNull(cars);
        Assert.assertNotNull(cars.get(0).getCar_id());
    }

    @Test
    public void testCreateCar() {
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
        car = carController.createCar(car);
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getCar_type(), car_type);
        Assert.assertEquals(car.getManufacturer(), manufacturer);
    }

    @Test
    public void testCreateCarNull() {
        Car car = new Car();
        car = carController.createCar(car);
        Assert.assertNull(car);
    }

    @Test
    public void testUpdateCar() {
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
        car = carController.updateCar(car);
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getModel(), model);
    }

    @Test
    public void testDeleteCar() {
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
        car = carController.deleteCar(car);
        Assert.assertNotNull(car);
    }


}
