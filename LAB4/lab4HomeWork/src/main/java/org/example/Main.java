package org.example;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.*;
public class Main {
    public static void generateFakeStudentsName(String[] fakeStudents){
        for(int i = 0; i < 10; ++i){
            Faker faker = new Faker();
            fakeStudents[i] = faker.name().firstName();
        }
    }

    public static void generateFakeProjectsName(String[] fakeProjects){
        for(int i = 0; i < 10; ++i){
            Faker faker = new Faker();
            fakeProjects[i] = faker.app().name();
        }
    }

    public static void main(String[] args){
        //Students topic
        String[] fakeStudents = new String[10];
        generateFakeStudentsName(fakeStudents);

        var students  = IntStream.rangeClosed(0,2).mapToObj(i-> new Student (fakeStudents[i])).toArray(Student[]:: new);
        List<Student> listStudents = new ArrayList<>();
        listStudents.addAll(Arrays.asList(students));
        System.out.print("Students: ");
        for(Student s: listStudents)
            System.out.print(s.getName() + "   ");

        System.out.println();

        //Projects topic
        String[] fakeProjects = new String[10];
        generateFakeProjectsName(fakeProjects);

        var projects = IntStream.rangeClosed(0,2).mapToObj(i-> new Project (fakeProjects[i])).toArray(Project[]:: new);
        List<Project> listProjects = new ArrayList<>();
        listProjects.addAll(Arrays.asList(projects));
        System.out.print("Projects: ");
        for(Project p: listProjects)
            System.out.print(p.getName() + "   ");
        System.out.println();


        //Problem topic
        Problem problem = new Problem();
        problem.setStudents(listStudents);
        problem.setProjects(listProjects);

        //convert list to array
        Project[] arrayProjects =  new Project[listProjects.size()];
        for(int i = 0; i < listProjects.size(); ++i)
            arrayProjects[i] = listProjects.get(i);

        problem.addProjectsForStudent(listStudents.get(0), new Project[]{arrayProjects[0], arrayProjects[1], arrayProjects[2]});
        problem.addProjectsForStudent(listStudents.get(1), new Project[]{arrayProjects[0], arrayProjects[1]});
        problem.addProjectsForStudent(listStudents.get(2), new Project[]{arrayProjects[0]});
        Map<Student,List<Project>> map = problem.getPrefMap();

        problem.displayStudentsWithPreferences();
        System.out.println();
        problem.displayStudentsWithLowPreferences();
        System.out.println();
        problem.greedySolution();
    }
}