package org.example;

public class Exploration {
    private int sizeMatrix,robotsNo;
    private Map map;
    private Robot[] robots;
    private Thread[] threads;
    private String[] names;

    public Exploration(int sizeMatrix,int robotsNo) {
        this.robotsNo = robotsNo;
        this.sizeMatrix = sizeMatrix;
        this.map = new Map(sizeMatrix);
        this.robots = new Robot[robotsNo];
        this.threads = new Thread[robotsNo];
    }

    public void start(){
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
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void resume(){;}
    public void end(){;}
}
