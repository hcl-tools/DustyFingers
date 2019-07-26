package com.dustyfingers.CarMS.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="color")
	private String color;
	
	@Column(name="license_plate", unique = true)
	@NotEmpty
	private String license_plate;
	
	@Column(name="seat_count")
	private int seat_count;
	
	@Column(name="rating")
	@PositiveOrZero
	private int rating;
	
	@Column(name="engine_type")
	private String engine_type;
	
	@Column(name="transmission")
	private boolean transmission;
	
	@Column(name="car_type")
	private String car_type;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Audit> Audits;
	
	public Car() {
		super();
	}
	

	public Car(int car_id, String model, String color, String license_plate, int seat_count, int rating,
			String engine_type, boolean transmission, String car_type, String manufacturer) {
		super();
		this.car_id = car_id;
		this.model = model;
		this.color = color;
		this.license_plate = license_plate;
		this.seat_count = seat_count;
		this.rating = rating;
		this.engine_type = engine_type;
		this.transmission = transmission;
		this.car_type = car_type;
		this.manufacturer = manufacturer;
	}


	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public boolean isTransmission() {
		return transmission;
	}

	public void setTransmission(boolean transmission) {
		this.transmission = transmission;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
}

