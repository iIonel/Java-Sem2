package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sizeMatrix,robotsNo;
        Scanner input = new Scanner(System.in);
        System.out.println("Size matrix: ");
        sizeMatrix = input.nextInt();
        System.out.println("Number of robots: ");
        robotsNo = input.nextInt();

        Exploration program = new Exploration(sizeMatrix,robotsNo);

        String[] names = new String[robotsNo];
        for(int i = 0; i < robotsNo; ++i){
            System.out.println("Name for a robot: ");
            names[i] = input.next();
        }
        program.addNames(names);
        program.addThreadsAndRobots();
        program.start();
        program.joinThreads();
    }
}