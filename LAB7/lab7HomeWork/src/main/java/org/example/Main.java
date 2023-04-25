package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sizeMatrix,robotsNo;
        long limitTime;
        Scanner input = new Scanner(System.in);

        System.out.print("START input keyboard (String format please!!!): ");
        Command start = new Command(input.next());
        System.out.println("Your START input keyboard: " + start.getKeyboard());

        System.out.print("PAUSE input keyboard (String format please!!!): ");
        Command pause = new Command(input.next());
        System.out.println("Your PAUSE input keyboard: " + pause.getKeyboard());

        System.out.print("Put a limit time for Timekeeper (in seconds): ");
        limitTime = input.nextLong();
        System.out.println("Your limit time is: " + limitTime);

        System.out.println("Size matrix: ");
        sizeMatrix = input.nextInt();
        System.out.println("Number of robots: ");
        robotsNo = input.nextInt();

        Exploration program = new Exploration(sizeMatrix,robotsNo,start,pause,limitTime);

        String[] names = new String[robotsNo];
        for(int i = 0; i < robotsNo; ++i){
            System.out.println("Name for a robot: ");
            names[i] = input.next();
        }
        program.addNames(names);
        program.addThreadsAndRobots();
        program.runningThreads();

        System.out.println();
        System.out.println();
        System.out.println("THE END OF PROGRAM!!!");
        for(int i = 0; i < robotsNo; ++i){
            System.out.println("------------------------------");
            System.out.println(program.getNameForRobot(i) + " --> " + program.getAllTokens(i) + " tokens");
        }
        System.out.println("------------------------------");
    }
}