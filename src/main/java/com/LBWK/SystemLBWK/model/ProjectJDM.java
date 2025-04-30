package com.LBWK.SystemLBWK.model;

import java.util.List;

public class ProjectJDM {
    private String projectName;
    private Car car;
    private List<Modification> steps;
    private Employee leaderProject;
    private boolean finished;

    public ProjectJDM(String projectName, Car car, List<Modification> steps, Employee leaderProject, boolean finished) {
        this.projectName = projectName;
        this.car = car;
        this.steps = steps;
        this.leaderProject = leaderProject;
        this.finished = finished;
    }

    public void finishProject() {
        this.finished = true;
    }

    public void summarizeProject() {
        System.out.println("Project Summary:");
        System.out.println("Project name: " + projectName);
        System.out.println("Leader: " + leaderProject.getName());
        System.out.println("Steps: ");
        if (steps != null && !steps.isEmpty()) {
            for (Modification step : steps) {
                System.out.println("- " + step.getName());
            }
        } else {
            System.out.println("- No modifications registered.");
        }
        System.out.println("Finished: " + finished);
    }

    public String getProjectName() {
        return projectName;
    }

    public Car getCar() {
        return car;
    }

    public List<Modification> getSteps() {
        return steps;
    }

    public Employee getLeaderProject() {
        return leaderProject;
    }

    public boolean isFinished() {
        return finished;
    }
}