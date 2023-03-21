package org.example;

public class Student {
    private String name;
    private int noProjects;

    public int getNoProjects() {
        return noProjects;
    }

    public void setNoProjects(int noProjects) {
        this.noProjects = noProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        noProjects = 0;

    }

    public Student(String name) {
        this.name = name;
    }
}