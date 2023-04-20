package com.example.pruebalab1;

import com.example.pruebalab1.models.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaLab1Application {

    public static void main(String[] args) {
        SpringApplication.run(PruebaLab1Application.class, args);

        System.out.println("hola mundo");

        Car car = new Car();

    }


}
