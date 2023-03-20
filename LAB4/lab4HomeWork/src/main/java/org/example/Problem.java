package org.example;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private Map<Student,List<Project>> prefMap;
    private List<Student> students;
    private List<Project> projects;



    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Problem() {
        this.projects = new ArrayList<>();
        this.prefMap = new HashMap<>();
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addProjectsForStudent(Student s, Project[] p){
        this.prefMap.put(s,Arrays.asList(p));
        for(int i = 0; i < p.length; ++i)
            p[i].addStudent(s);
        s.setNoProjects(p.length);
    }

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public void setPrefMap(Map<Student, List<Project>> prefMap) {
        this.prefMap = prefMap;
    }

    public void displayStudentsWithPreferences(){
       for(Project p: projects){
           System.out.println();
           List<Student> actualStudents = students.stream()
                   .filter(s->prefMap.get(s).contains(p))
                   .collect(Collectors.toList());

           System.out.print("Project " + p.getName() + " with: ");
           for(Student s: actualStudents)
               System.out.print(s.getName() + " ");
       }
    }

    public void displayStudentsWithLowPreferences(){
        System.out.println();
        int allPreferences = 0;
        for(Student s: prefMap.keySet()){
            allPreferences += prefMap.get(s).size();
        }
        int averagePreferences = allPreferences/(students.size());
        System.out.print("Students that have a number of preferences lower than the average number of preferences are: ");
        for(Student s: prefMap.keySet()){
            if(prefMap.get(s).size() < averagePreferences)
                System.out.print(s.getName() + " ");
        }
    }

    public void greedySolution() {
        System.out.println();
        Collections.sort(students,Comparator.comparing(Student::getNoProjects));
        Collections.sort(projects,Comparator.comparing(Project::getNoStudents));
        for(Student s: students){
            List<Project> actualProjects = prefMap.get(s).stream().toList();
            for(Project p: actualProjects) {
                if(p.isReached() == false) {
                    System.out.println("Student " + s.getName() + " take " + p.getName());
                    p.setReached(true);
                    break;
                }
            }
        }
    }
}
