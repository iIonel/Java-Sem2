package org.example;
import java.util.Random;

public class Robot implements Runnable {
    private final String name;
    private int tokenNo;
    private int xPos,yPos;
    private final Map map;
    private int token;
    private final Random random = new Random();

    public Robot(String name, Map map) {
        this.tokenNo = 0;
        this.xPos = random.nextInt(map.getSize());
        this.yPos = random.nextInt(map.getSize());
        this.name = name;
        this.map = map;
        this.token = 0;
    }
    public void run() {
            while (!map.isFullyExplored() && !map.nevalidPositions(xPos, yPos)) {
                int direction = random.nextInt(4);
                if (direction == 0) //up
                    this.xPos = this.xPos - 1;
                else if (direction == 1) //down
                    this.xPos = this.xPos + 1;
                else if (direction == 2) //left
                    this.yPos = this.yPos - 1;
                else //right
                    this.yPos = this.yPos + 1;

                if (xPos < map.getSize() && yPos < map.getSize() && xPos >= 0 && yPos >= 0) {
                    map.moveRobot(this, xPos, yPos);
                    if (!map.isCellVisited(xPos, yPos)) {
                        token = map.extractTokens(xPos, yPos);
                        System.out.println(name + " collected " + map.getTokens(xPos, yPos, map.getSize()) + " token at map[" + xPos + ", " + yPos + "]");
                        tokenNo++;
                    }
                }try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        end();
    }

    public void end(){
        System.out.println(getName() + " take all tokens!");
    }

    public String getName() {
        return name;
    }

    public int getToken() {
        return token;
    }

    public int getTokenNo() {
        return 10*tokenNo;
    }



}
