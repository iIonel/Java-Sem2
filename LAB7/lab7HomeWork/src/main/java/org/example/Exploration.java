package org.example;

import java.util.Scanner;

public class Exploration {
    private int sizeMatrix,robotsNo;
    private long limitTime;
    private boolean end;
    private Command start;
    private Command pause;
    private boolean started;
    private Map map;
    private Robot[] robots;
    private Thread[] threads;
    private String[] names;
    private Timekeeper threadTime;

    public Exploration(int sizeMatrix, int robotsNo, Command start, Command pause, long limitTime) {
        this.limitTime = limitTime;
        this.end = false;
        this.started = true;
        this.start = start;
        this.pause = pause;
        this.robotsNo = robotsNo;
        this.sizeMatrix = sizeMatrix;
        this.map = new Map(sizeMatrix);
        this.robots = new Robot[robotsNo];
        this.threads = new Thread[robotsNo];
    }

    public void start(){
        this.threadTime = new Timekeeper(robotsNo,limitTime, System.currentTimeMillis(), threads);
        for (int i = 0; i < robotsNo; i++) {
            threads[i].start();
        }
    }

    public void addNames(String [] names){
        this.names = names;
    }

    public void addThreadsAndRobots(){
        for (int i = 0; i < robotsNo; i++) {
            this.robots[i] = new Robot(names[i], map);
            this.threads[i] = new Thread(robots[i]);
        }
    }

    public void joinThreads() {
        for (int i = 0; i < robotsNo; i++) {
            try {
                threads[i].join();//threadTime.setLimitTime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //threadTime.start();
    }
    public void interruptedThreas(){
        threadTime.interrupt();
        for(int i = 0; i < robotsNo; ++i){
            threads[i].interrupt();
        }
    }
    public void runningThreads(){
            if (started == true) {
                start();
                joinThreads();
            } else {
                interruptedThreas();
            }
    }

    public String getNameForRobot(int i){
        return names[i];
    }

    public int getAllTokens(int i){
        return robots[i].getTokenNo();
    }

    public Command getStart() {
        return start;
    }

    public void setStart(Command start) {
        this.start = start;
    }

    public Command getPause() {
        return pause;
    }

    public void setPause(Command pause) {
        this.pause = pause;
    }
}
