package com.LBWK.SystemLBWK.service;

import com.LBWK.SystemLBWK.model.Client;
import com.LBWK.SystemLBWK.util.ValidateUtil;

import java.util.List;
import java.util.Scanner;

public class ClientService {
    public void clientMenu(Scanner scanner, List<Client> listClient){
        int option = -1;

        while(option != 0){
            System.out.println("\n--- CLIENT MENU ---");
            System.out.println("1. Register client");
            System.out.println("2. List clients");
            System.out.println("0. Exit");

            System.out.println("Choose an option:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> registerClient(scanner, listClient);
                case 2 -> listClients(listClient);
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void registerClient(Scanner scanner, List<Client> listClient){
        System.out.println("Register a new user");
        System.out.println("--------------------");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        name = ValidateUtil.ValidateInputString(name, "Name");

        System.out.print("Enter customer CPF (only numbers): ");
        long cpf = Long.parseLong(scanner.nextLine());
        cpf = ValidateUtil.ValidateInputCPF(cpf);


        System.out.print("Enter customer nationality: ");
        String nationality = scanner.nextLine();
        nationality = ValidateUtil.ValidateInputString(nationality, "nationality");

        Client client = new Client(name, cpf, nationality, null);
        listClient.add(client);

        System.out.println("Client registered successfully!");
    }

    public void listClients(List<Client> listClient){
        for (Client c : listClient){
            System.out.println("Name: " + c.getName());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Nationality: " + c.getNationality());
            System.out.println("------------------------------");
        }
    }
}
