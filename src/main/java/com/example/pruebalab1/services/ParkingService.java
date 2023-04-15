package com.example.pruebalab1.services;

import com.example.pruebalab1.models.Car;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private List <Car> parkinglot;
    private static final double HOURLY_RATE = 2.5;


    public ParkingService() {
        this.parkinglot = new ArrayList<>();
    }

    public List<Car> getAllCars(){
        return this.parkinglot;
    }

    public Optional <Car> getCarByLicensePlate(String licensePlate) {
        return this.parkinglot.stream().filter(car -> car.getLicensePlate().equals(licensePlate)).findFirst();
    }

    public List<Car> getCarsByColor(String color) {
        return this.parkinglot.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    public void addCar(Car car) {
        this.parkinglot.add(car);
    }


    public boolean removeCarByLicensePlate(String LicensePlate) {
        return this.parkinglot.removeIf(car -> car.getLicensePlate().equals(LicensePlate));
    }







}
