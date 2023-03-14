package org.example;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        List<Student> listStudents = new ArrayList<>();
        for(Student s: students){
            listStudents.add(s);
        }
        for(Student s: students)
            System.out.println(s.getName());

        var projects = IntStream.range(0,3)
                .mapToObj(i->new Project("P" + i))
                .toArray(Project[]::new);
        Set<Project> treeProjects = new TreeSet<>();
        for(Project p: projects){
            treeProjects.add(p);
        }
        for(Project p: projects)
            System.out.println(p.getName());

    }
}