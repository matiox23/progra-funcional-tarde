package com.example.pruebalab1.services;

import com.example.pruebalab1.models.Car;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private List<Car> parkinglot;
    private static final double HOURLY_RATE = 2.5;


    public ParkingService() {
        this.parkinglot = new ArrayList<>();
    }

    public List<Car> getAllCars() {
        return this.parkinglot;
    }

    public Optional<Car> getCarByLicensePlate(String licensePlate) {
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

    public void parKcar(Car car) {
        car.setEntryTime(LocalDateTime.now());
        addCar(car);
    }

    public void unparkCar(String licensePlate) {
        removeCarByLicensePlate(licensePlate);
    }

    public double calculateParkingFee(String licensePlate) {
        Optional<Car> optionalCar = getCarByLicensePlate(licensePlate);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            LocalDateTime entryTime = car.getEntryTime();
            if (entryTime != null) {
                Long hoursParked = ChronoUnit.HOURS.between(entryTime, LocalDateTime.now());
                return hoursParked * HOURLY_RATE;
            }
        }
        return 0;
    }
}










