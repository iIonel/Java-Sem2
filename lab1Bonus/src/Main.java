import javax.sound.midi.SysexMessage;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int matrix[][] = new int[100][100];
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        System.out.println("A^1");
        for(int i = 0; i < n; ++i){
            if(i == 0) matrix[i][n - 1] = 1;
            else matrix[i][i - 1] = 1;

            if(i == n - 1) matrix[i][0] = 1;
            else matrix[i][i + 1] = 1;
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        int a[][] = new int[100][100];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                a[i][j] = matrix[i][j];

        for(int p = 2; p <= n; ++p){
            System.out.println("A^" + p);
            System.out.println();
            int b[][] = new int[100][100];
            for(int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j){
                    b[i][j] = 0;
                    for(int k = 0; k < n; ++k){
                        b[i][j] += a[i][k] * matrix[k][j];
                    }
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();
            }
            for(int i = 0; i < n; ++i)
                for(int j = 0; j < n; ++j)
                    a[i][j] = b[i][j];
            System.out.println();
        }
    }
}