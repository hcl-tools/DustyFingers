package com.dustyfingers.CarMS.controller;

import com.dustyfingers.CarMS.model.Car;
import com.dustyfingers.CarMS.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/v1")
@RestController
public class CarController {

    @Autowired
    @Qualifier("carService")
    private CarServiceImpl carService;

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        return new ResponseEntity<String>("goof", HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{car}", method = RequestMethod.GET)
    public ResponseEntity<Car> getCar(@PathVariable("car") @NotBlank String car) {
        try {
            return new ResponseEntity<Car>(carService.findCarById(Integer.parseInt(car)), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            return new ResponseEntity<List<Car>>(carService.findAllCars(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
