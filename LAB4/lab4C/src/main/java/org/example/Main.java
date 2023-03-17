package org.example;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0,3).mapToObj(i-> new Student ("S" + i)).toArray(Student[]:: new);

        List<Student> listStudents = new ArrayList<>();
        listStudents.addAll(Arrays.asList(students));
        Collections.sort(listStudents, Comparator.comparing(Student::getName));
        for(Student s: listStudents)
            System.out.print(s.getName() + " ");

        System.out.println();

        var projects = IntStream.rangeClosed(0,2).mapToObj(i-> new Project ("P" + i)).toArray(Project[]:: new);
        TreeSet<Project> setProjects = new TreeSet<Project>();
        setProjects.addAll(Arrays.asList(projects));

        System.out.print(setProjects);
    }
}