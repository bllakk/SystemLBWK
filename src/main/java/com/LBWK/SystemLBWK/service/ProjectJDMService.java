package com.LBWK.SystemLBWK.service;

import com.LBWK.SystemLBWK.model.Car;
import com.LBWK.SystemLBWK.model.Client;
import com.LBWK.SystemLBWK.model.Employee;
import com.LBWK.SystemLBWK.model.ProjectJDM;
import com.LBWK.SystemLBWK.util.FinderUtil;
import com.LBWK.SystemLBWK.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectJDMService {
    public void ProjectJDMMenu(Scanner scanner, List<ProjectJDM> listProject, List<Client> listClient, List<Employee> listEmployee){
        int option = -1;

        while(option != 0){
            System.out.println("\n--- PROJECT MENU ---");
            System.out.println("1. Register Project");
            System.out.println("2. List Project");
            System.out.println("0. Exit");

            System.out.println("Choose an option:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> registerProject(scanner, listProject, listClient, listEmployee);
                case 2 -> listProjects(listProject);
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void registerProject(Scanner scanner, List<ProjectJDM> listProject, List<Client> listClient, List<Employee> listEmployee){
        System.out.println("Register project");
        System.out.println("--------------------");

        System.out.println("Enter name project: ");
        String projectName = scanner.nextLine();
        projectName = ValidateUtil.ValidateInputString(projectName, "Project Name");

        Employee foundEmployee = FinderUtil.findEmployeeById(scanner, listEmployee);
        Client foundClient = FinderUtil.findClientByCpf(scanner, listClient);

        List<Car> foundClientCar = foundClient.getCars();
        if (foundClientCar.isEmpty()){
            System.out.println("This client has no registered cars.");
            return;
        }

        System.out.println("Select a car for the project:");
        for (int i = 0; i < foundClientCar.size(); i++){
            System.out.println((i + 1) + ". " + foundClientCar.get(i).getModel());
        }

        int carIndex = scanner.nextInt();;
        scanner.nextLine();

        if (carIndex < 1 || carIndex > foundClientCar.size()){
            System.out.println("Invalid selection.");
            return;
        }
        Car selectedCar = foundClientCar.get(carIndex - 1);
        System.out.println("Selected car: " + selectedCar.getModel());

        // Criação do projeto
        ProjectJDM newProject = new ProjectJDM(projectName, selectedCar, new ArrayList<>(), foundEmployee, false);
        listProject.add(newProject);
        System.out.println("Project registered successfully!");
    }
    public void listProjects(List<ProjectJDM> listProject){
        for (ProjectJDM p : listProject){
            System.out.println("Name: " + p.getProjectName());
            System.out.println("Leader Project - " + p.getLeaderProject());
            System.out.println("Resume Car -  " + p.getCar());
            System.out.println("------------------------------");
        }
    }
}
