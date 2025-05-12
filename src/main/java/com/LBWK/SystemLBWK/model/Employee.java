package com.LBWK.SystemLBWK.model;

import com.LBWK.SystemLBWK.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String position;
    private List<Modification> assignments;

    public void assignTask(Modification m){
        assignments.add(m);
    }

    public void listTasks(){
        for (Modification m : assignments) {
            System.out.println(m);
        }
    }

    public Employee(int id, String name, String position, List<Modification> assignments) {
        this.id = id;
        this.name = ValidateUtil.validateNotBlank(name, "Name");
        this.position = ValidateUtil.validateNotBlank(position, "position");
        this.assignments = (assignments == null) ? new ArrayList<>() : assignments;
    }

    @Override
    public String toString(){
        return "ID: " + id +", Name: " + name + ", Position: " + position;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public List<Modification> getAssignments() {
        return assignments;
    }
}