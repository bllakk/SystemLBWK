package com.LBWK.SystemLBWK.service;

import com.LBWK.SystemLBWK.model.Employee;
import com.LBWK.SystemLBWK.util.ValidateUtil;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public void employeeMenu(Scanner scanner, List<Employee> listEmployee){
        int option = -1;

        while(option != 0){
            System.out.println("\n--- EMPLOYEE MENU ---");
            System.out.println("1. Register Employee");
            System.out.println("2. List Employee");
            System.out.println("0. Exit");

            System.out.println("Choose an option:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> registerEmployee(scanner, listEmployee);
                case 2 -> listEmployees(listEmployee);
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void registerEmployee(Scanner scanner, List<Employee> listEmployee){
        System.out.println("Register a new Employee");
        System.out.println("--------------------");

        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        name = ValidateUtil.ValidateInputString(name, "name");

        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        position = ValidateUtil.ValidateInputString(position, "position");

        Employee employee = new Employee(id, name, position, null);
        listEmployee.add(employee);

        System.out.println("Employee registered successfully!");
    }

    public void listEmployees(List<Employee> listEmployee){
        for (Employee e : listEmployee){
            System.out.println("Name: " + e.getName());
            System.out.println("ID: " + e.getId());
            System.out.println("Position: " + e.getPosition());
            System.out.println("assignments: " + e.getAssignments());
            System.out.println("------------------------------");
        }
    }
}
