package com.LBWK.SystemLBWK.model;

import com.LBWK.SystemLBWK.exception.DuplicateModificationException;
import com.LBWK.SystemLBWK.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int year;
    private Client owner;
    private List<Modification> modifications;

    public Car(String brand, String model, int year, Client owner, List<Modification> modifications) {
        this.brand = ValidateUtil.validateNotBlank(brand, "Brand");
        this.model = ValidateUtil.validateNotBlank(model, "Model");
        this.year = ValidateUtil.validateYear(year);
        this.owner = owner;
        this.modifications = (modifications == null) ? new ArrayList<>() : modifications;
    }

    public void addModification(Modification m){
        if (modifications.contains(m)){
            throw new DuplicateModificationException(m.getName());
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

    @Override
    public String toString(){
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Owner: " + getOwner().getName();
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

}