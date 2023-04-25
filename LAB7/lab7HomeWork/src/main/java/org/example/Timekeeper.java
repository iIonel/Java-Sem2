package org.example;

public class Timekeeper extends Thread{
    private long startTime;
    private long limitTime;
    private int robotsNo;
    private Thread[] threads;

    public void setLimitTime() {
        this.limitTime = this.limitTime -1000;
    }

    public Timekeeper(int robotsNo, long limitTime, long startTime, Thread[] threads) {
        this.robotsNo = robotsNo;
        this.threads = new Thread[robotsNo];
        this.threads = threads;
        this.startTime = startTime;
        this.limitTime = limitTime;
        setDaemon(true);
    }
    @Override
    public void run(){
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Elapsed time: " + elapsedTime / 1000 + " seconds");

            if (elapsedTime >= limitTime*60) {
                System.out.println("Process time: " + elapsedTime + "miliseconds");
                System.out.println("Time limit exceeded, stopping all robots.");
                for(Thread t: threads){
                    t.interrupt();
                }
                break;
            }
        }
    }
}
