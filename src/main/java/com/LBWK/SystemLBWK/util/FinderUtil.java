package com.LBWK.SystemLBWK.util;

import com.LBWK.SystemLBWK.model.Client;
import com.LBWK.SystemLBWK.model.Employee;

import java.util.List;
import java.util.Scanner;

public class FinderUtil {
    public static Client findClientByCpf(Scanner scanner, List<Client> listClient) {
        Client foundClient = null;
        while (foundClient == null) {
            System.out.println("Enter client CPF: ");
            String inputCpf = scanner.nextLine().trim(); // Remove espaços extras

            // Verifica se o CPF está vazio
            if (inputCpf.isEmpty()) {
                System.out.println("CPF cannot be empty. Please try again.");
                continue; // Retorna para a pergunta sem tentar converter
            }

            try {
                long searchCPF = Long.parseLong(inputCpf); // Tenta converter para long

                for (Client c : listClient) {
                    if (c.getCpf() == searchCPF) {
                        foundClient = c;
                        break;
                    }
                }

                if (foundClient == null) {
                    System.out.println("Client not found. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid CPF format. Please enter a valid CPF (only numbers).");
            }
        }
        return foundClient;
    }


    public static Employee findEmployeeById(Scanner scanner, List<Employee> listEmployee){
        Employee foundEmployee = null;
        while (foundEmployee == null){
            System.out.println("Enter employee ID: ");
            int idEmployee = scanner.nextInt();
            scanner.nextLine();

            for (Employee e : listEmployee){
                if (e.getId() == idEmployee){
                    foundEmployee = e;
                    break;
                }
            }
            if (foundEmployee == null){
                System.out.println("Employee not found. Try again.");
            }
        }
        return foundEmployee;
    }
}
