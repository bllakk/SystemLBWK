package com.LBWK.SystemLBWK.service;

import com.LBWK.SystemLBWK.model.Car;
import com.LBWK.SystemLBWK.model.Client;
import com.LBWK.SystemLBWK.util.FinderUtil;

import java.util.List;
import java.util.Scanner;

public class CarService {
    public void carMenu(Scanner scanner, List<Car> listCars, List<Client> listClient) {
        int option = -1;

        while (option != 0) {
            System.out.println("\n--- CAR MENU ---");
            System.out.println("1. Register car");
            System.out.println("2. List car");
            System.out.println("0. Exit");

            System.out.println("Choose an option:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerCar(scanner, listCars, listClient);
                case 2 -> listCar(scanner, listClient);
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }
        }
    }
    public void registerCar(Scanner scanner, List<Car> listCars, List<Client> listClient){
        System.out.println("Register a new user");
        System.out.println("--------------------");
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Client foundClient = FinderUtil.findClientByCpf(scanner, listClient);

        Car car = new Car(brand, model, year, foundClient, null);
        listCars.add(car);
        foundClient.getCars().add(car);
        System.out.println("Car registered successfully!");
    }

    public void listCar(Scanner scanner, List<Client> listClient){
        System.out.println("Car listing for a client");
        System.out.println("--------------------");

        Client foundClient = FinderUtil.findClientByCpf(scanner, listClient);
        List<Car> foundClientCar = foundClient.getCars();
        for (Car c : foundClientCar){
            System.out.println("Name: " + c.getBrand());
            System.out.println("ID: " + c.getModel());
            System.out.println("Year: " + c.getYear());
            System.out.println("------------------------------");
        }
    }
}
