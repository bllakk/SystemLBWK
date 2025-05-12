package com.LBWK.SystemLBWK;

import com.LBWK.SystemLBWK.model.*;
import com.LBWK.SystemLBWK.service.CarService;
import com.LBWK.SystemLBWK.service.ClientService;
import com.LBWK.SystemLBWK.service.EmployeeService;
import com.LBWK.SystemLBWK.service.ProjectJDMService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        List<Client> listClient = new ArrayList<>();
        List<Car> listCars = new ArrayList<>();
        List<Employee> listEmployee = new ArrayList<>();
        List<ProjectJDM> listProject = new ArrayList<>();

        ClientService clientService = new ClientService();
        CarService carService = new CarService();
        EmployeeService employeeService = new EmployeeService();
        ProjectJDMService projectJDMService = new ProjectJDMService();

        while (option != 0) {
            System.out.println("Welcome to the SystemLBWK");
            System.out.println("Select the desired menu");
            System.out.println("1. Client");
            System.out.println("2. Car");
            System.out.println("3. Employee");
            System.out.println("4. Projects");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> clientService.clientMenu(scanner, listClient);
                case 2 -> carService.carMenu(scanner, listCars, listClient);
                case 3 -> employeeService.employeeMenu(scanner, listEmployee);
                case 4 -> projectJDMService.ProjectJDMMenu(scanner, listProject, listClient, listEmployee);
            }
        }

        scanner.close();
    }
}