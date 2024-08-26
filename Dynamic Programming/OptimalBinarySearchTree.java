
import java.util.*;
 
public class Main {
    static final int MAX = 1000;
    static int cost[][] = new int[MAX][MAX];
 
    static int Sum(int freq[], int i, int j)
    {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }
 
    static int optCost_memoized(int freq[], int i, int j)
    {
        if (i < 0 || j < 0)
            return 0;
        if (cost[i][j] != 0)
            return cost[i][j];
        int fsum = Sum(freq, i, j);
 
        int Min = Integer.MAX_VALUE;
 
        for (int r = i; r <= j; r++) {
            int c = optCost_memoized(freq, i, r - 1)
                    + optCost_memoized(freq, r + 1, j)
                    + fsum;
            if (c < Min) {
                Min = c;
                cost[i][j] = c;
            }
        }
 
        return cost[i][j];
    }
 
    static int optimalSearchTree(int keys[], int freq[],
                                 int n)
    {
        return optCost_memoized(freq, 0, n - 1);
    }
 
    public static void main(String[] args)
    {
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
 
        for (int i = 0; i < n; i++)
            Arrays.fill(cost[i], 0);
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];
 
        System.out.println(
            "Cost of Optimal BST is "
            + optimalSearchTree(keys, freq, n));
    }
}