package com.LBWK.SystemLBWK.model;

import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int year;
    private Client owner;
    private List<Modification> modifications;

    public Car(String brand, String model, int year, Client owner, List<Modification> modifications) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.modifications = modifications;
    }

    public void addModification(Modification m){
        if (modifications.contains(m)){
            //Exception
        }
        modifications.add(m);
    }
    public float calculateCost(){
        float totalCost = 0;
        for (Modification m : modifications){
            totalCost += m.getCost();
        }
        return totalCost;
    }

    public void technicalSheet() {
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Model: " + this.getModel());
        System.out.println("Year: " + this.getYear());
        System.out.println("Owner: " + this.getOwner().getName());
        System.out.println("Modifications: ");
        for (Modification m : this.getModifications()){
            System.out.println("- " + m.getName() + ": $" + m.getCost());
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Client getOwner() {
        return owner;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public static class ModMotor extends Modification{
        private int horsePower;
        private String fuelType;

        public ModMotor(String name, double cost, Employee responsible, int horsePower, String fuelType) {
            super(name, cost, responsible);
            this.horsePower = horsePower;
            this.fuelType = fuelType;
        }


        @Override
        void executeModification() {
            System.out.println("Installing motor modification: " + this.getName());
            System.out.println("Horse Power: " + this.horsePower);
            System.out.println("Fuel Type: " + this.fuelType);
            System.out.println("Cost: $" + this.getCost());
            System.out.println("Responsible com.LBWK.SystemLBWK.model.Employee: " + this.getResponsible().getName());
        }
    }
}