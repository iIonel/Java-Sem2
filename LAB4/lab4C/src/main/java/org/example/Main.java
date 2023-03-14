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

        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray((Project[]::new));

        Set<Project> treeOfProjects = new TreeSet<>();
        treeOfProjects.addAll(Arrays.asList(projects));

        for(Project project : projects)
        {
            System.out.println(project.getName());
        }

    }
}