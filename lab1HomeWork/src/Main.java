import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) {
        //TASK 1
        int n;
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        if(n < 30000) {
            System.out.println(n + " este numar intreg");
            //TASK 2
            int[][] latinMatrix = new int[n + 1][n + 1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j)
                    latinMatrix[1][j] = j;
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (j < n)
                        latinMatrix[i + 1][j + 1] = latinMatrix[i][j];
                    else
                        latinMatrix[i + 1][j - n + 1] = latinMatrix[i][j];
                }
            }
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j)
                    System.out.print(latinMatrix[i][j] + " ");
                System.out.println();
            }

            //TASK 3
            String s = " ";
            for (int i = 1; i <= n; ++i) {
                s =" ";
                for (int j = 1; j <= n; ++j) {
                    s += latinMatrix[i][j];
                }
                System.out.println(s);
            }
            System.out.println();
            for (int i = 1; i <= n; ++i) {
                s = " ";
                for (int j = 1; j <= n; ++j) {
                    s += latinMatrix[j][i];
                }
                System.out.println(s);
            }
        }
        else{
            //TASK 4
            long start = System.nanoTime();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("nanoseconds: " + time);
            System.out.println("miliseconds: " + time/1000000);

        }
    }
}