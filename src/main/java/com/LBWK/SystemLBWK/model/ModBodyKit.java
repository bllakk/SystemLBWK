package com.LBWK.SystemLBWK.model;

public class ModBodyKit extends Modification {
    private String manufacturer;
    private boolean isCarbonFiber;

    public ModBodyKit(String name, double cost, Employee responsible, String manufacturer, boolean isCarbonFiber) {
        super(name, cost, responsible);
        this.manufacturer = manufacturer;
        this.isCarbonFiber = isCarbonFiber;
    }

    @Override
    void executeModification() {
        System.out.println("Installing body kit: " + this.getName());
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Material: " + (this.isCarbonFiber ? "Carbon Fiber" : "Plastic"));
        System.out.println("Cost: $" + this.getCost());
        System.out.println("Responsible com.LBWK.SystemLBWK.model.Employee: " + this.getResponsible().getName());
    }
}