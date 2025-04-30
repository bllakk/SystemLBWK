package com.LBWK.SystemLBWK.model;

public abstract class Modification {
    private String name;
    private double cost;
    private Employee responsible;

    public Modification(String name, double cost, Employee responsible) {
        this.name = name;
        this.cost = cost;
        this.responsible = responsible;
    }

    abstract void executeModification();

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Employee getResponsible() {
        return responsible;
    }
}