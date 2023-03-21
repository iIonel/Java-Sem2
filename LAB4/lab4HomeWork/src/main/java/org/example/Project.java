package org.example;
import java.util.Comparator;

public class Project implements Comparable<Project>{
    private String name;
    private int noStudents;

    private boolean isReached;

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }

    public int getNoStudents() {
        return noStudents;
    }

    public void setNoStudents(int noStudents) {
        this.noStudents = noStudents;
    }

    public void addStudent(Student s){
        this.noStudents += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(String name) {
        this.name = name;
        this.noStudents = 0;
        this.isReached = false;
    }

    @Override
    public int compareTo(Project o) {
        return 0;
    }
}