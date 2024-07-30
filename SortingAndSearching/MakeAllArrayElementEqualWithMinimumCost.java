import java.io.*;
import java.util.*;
 
class Solution{ 
public static int minCostToMakeElementEqual(int a[],  int n)
{
    int y; 
    if (n % 2 == 1) 
        y = a[n / 2];  
    else
        y = (a[n / 2] + a[(n - 2) / 2]) / 2; 
    int s = 0; 
     
    for(int i = 0; i < n; i++) 
        s += Math.abs(a[i] - y); 
     
    return s; 
}
public static void main (String[] args) 
{
    int a[] = { 1, 100, 101 };
   
      Arrays.sort(a);
    int n = a.length;
     
    System.out.println(minCostToMakeElementEqual(a, n));
}
}