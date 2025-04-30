package com.LBWK.SystemLBWK.model;

public class ModMotor extends Modification{
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