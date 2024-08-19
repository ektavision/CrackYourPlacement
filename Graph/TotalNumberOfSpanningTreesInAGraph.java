
import java.util.*;

public class Main {
    static final int MAX = 100;
    static final int MOD = 1000000007;
    static void multiply(int A[][], int B[][], int C[][])
    {
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                for (int k = 0; k < MAX; k++)
                    C[i][j] = (int)((C[i][j]
                                     + (A[i][k] * B[k][j])
                                           % MOD)
                                    % MOD);
    }

    static void power(int A[][], int N, int result[][])
    {
        int temp[][] = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                result[i][j] = (i == j) ? 1 : 0;
        while (N > 0) {
            if (N % 2 == 1) {
                multiply(A, result, temp);
                for (int i = 0; i < MAX; i++)
                    for (int j = 0; j < MAX; j++)
                        result[i][j] = temp[i][j];
            }
            N = N / 2;
            multiply(A, A, temp);
            for (int i = 0; i < MAX; i++)
                for (int j = 0; j < MAX; j++)
                    A[i][j] = temp[i][j];
        }
    }
    static int numOfSpanningTree(int graph[][], int V)
    {
        int result[][] = new int[MAX][MAX];
        int temp[][] = new int[MAX][MAX];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                temp[i][j] = graph[i][j];
        power(temp, V - 2, result);
        int ans = 0;
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                ans = (int)((ans + result[i][j]) % MOD);
        return ans;
    }

    public static void main(String[] args)
    {
        int V = 4; 
        int E = 5; 
        int graph[][] = { { 0, 1, 1, 1 },
                          { 1, 0, 1, 1 },
                          { 1, 1, 0, 1 },
                          { 1, 1, 1, 0 } };
        System.out.println(numOfSpanningTree(graph, V));
    }
}