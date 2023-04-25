package org.example;
import java.util.List;
import java.util.Random;

public class Map {
    private int[][] tokens;
    private boolean[][] visited;
    private Robot[][] robots;
    private int size;

    public Map(int size) {
        this.size = size;
        this.tokens = new int[size][size];
        this.visited = new boolean[size][size];
        this.robots = new Robot[size][size];
        initTokens();
    }

    private void initTokens() {
        int n = size*size*size;
        int[] shuffled = new int[n];
        for (int i = 0; i < n; i++) {
            shuffled[i] = i + 1;
        }
        shuffle(shuffled);
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tokens[i][j] = shuffled[index++];
            }
        }
    }

    private void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public synchronized void moveRobot(Robot robot, int x, int y) {
        int currentX = -1, currentY = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (robots[i][j] == robot) {
                    currentX = i;
                    currentY = j;
                    break;
                }
            }
        }
        if (currentX != -1 && currentY != -1) {
            robots[currentX][currentY] = null;
        }
        robots[x][y] = robot;
    }

    public synchronized int extractTokens(int x, int y) {
        visited[x][y] = true;
        return tokens[x][y];
    }

    public synchronized boolean isCellVisited(int x, int y) {
        return visited[x][y];
    }

    public boolean isFullyExplored() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getTokens(int x, int y, int size) {
        return tokens[x][y];
    }

    public boolean goodPositions(int x, int y){
        if(x >= 0 && x < size && y >= 0 && y < size) return true;
        return false;
    }

    public boolean nevalidPositions(int x, int y){
        if(goodPositions(x -1,y) && goodPositions(x+1,y) && goodPositions(x,y + 1) && goodPositions(x, y - 1))
            if(visited[x-1][y] && visited[x + 1][y] && visited[x][y + 1] && visited[x][y-1]) return true;
        return false;
    }
    public int getSize() {
        return size;
    }
}
