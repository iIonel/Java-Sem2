import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        int matrix[][] = new int[100][100];
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int degree = stdin.nextInt();
        int degrees[] = new int[100];
        for(int i = 0; i < n; ++i) degrees[i] = degree;

        for(int i = 0; i < n; ++i)
            for(int j = i + 1; j < n; ++j)
                if(degrees[i] != 0 && degrees[j] != 0)
                {
                    degrees[i] -=1;
                    degrees[j] -=1;
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
