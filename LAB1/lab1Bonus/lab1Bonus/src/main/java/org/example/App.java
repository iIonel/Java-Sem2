package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int Read()
    {
        Scanner keyboard = new Scanner(System.in);
        while (!keyboard.hasNextInt())
        {
            System.out.print("Please enter an integer value: ");
            keyboard.next();
        }
        return keyboard.nextInt();
    }

    public static void main( String[] args )
    {
        System.out.print("Enter an integer value, number of vertices of cycle graph: ");
        int n = Read();

        int[][] adj = new int[n][n];

        for(int i = 0; i<n; i++)
        {
            adj[i][(i+1)%n] = 1;
            adj[(i+1)%n][i] = 1;
        }

        int[][] adjPow;
        adjPow = adj;
        for(int k = 2; k<=n; k++)
        { int[][] adjAux = new int [n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                {   adjAux[i][j] = 0;
                    for (int p = 0; p < n; p++)
                    {
                        adjAux[i][j] += adj[i][p] * adjPow[p][j];
                    }
                }
            adjPow = adjAux;
            System.out.println("Power " + k);
            for(int i = 0; i < n; i++)
            { for(int j = 0; j < n; j++)
            {
                System.out.print(adjPow[i][j] + " ");
            }
                System.out.println();
            }
        }
    }
}
