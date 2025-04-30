package com.LBWK.SystemLBWK.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private long cpf;
    private String nationality;
    private List<Car> cars;

    public Client(String name, long cpf, String nationality, List<Car> cars) {
        this.name = name;
        this.cpf = cpf;
        this.nationality = nationality;
        this.cars = (cars == null) ? new ArrayList<>() : cars;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }
    public void listCars(){
        for (Car c : cars){
            System.out.println("List of cars: " + c.getBrand() + " " + c.getModel() + " " + c.getYear());
        }
    }

    public String getName() {
        return name;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Car> getCars() {
        return cars;
    }
}