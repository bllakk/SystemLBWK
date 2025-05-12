package com.LBWK.SystemLBWK.util;

import java.util.Calendar;

public class ValidateUtil {
    public static String validateNotBlank(String valor, String campo){
        if (valor == null || valor.isBlank()){
            throw new IllegalArgumentException(campo + " - This field cannot be empty!");
        }
        return valor;
    }

    public static int validateYear(int yearCar){
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        if (yearCar < 0 || yearCar > currentYear){
            throw new IllegalArgumentException("Year of car cannot be greater than " + currentYear + "!");
        }
        return yearCar;
    }

    public static Long validateCPF(Long cpf){
        String cpfStr = String.valueOf(cpf);
        if (cpfStr.length() != 11 || cpfStr.isBlank()){
            throw new IllegalArgumentException("CPF cannot be less than 11 digits");
        }
        return cpf;
    }

    public static Long ValidateInputCPF(Long cpf){
        try {
            return ValidateUtil.validateCPF(cpf);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static String ValidateInputString(String valor, String campo){
        try {
            return ValidateUtil.validateNotBlank(valor, campo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static int ValidateInputYear(int year){
        try {
            return ValidateUtil.validateYear(year);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
