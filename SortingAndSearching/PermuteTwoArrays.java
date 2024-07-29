
import java.util.*;
class GFG 
{
static boolean twoArray(Integer a[], int b[], int n, int k) 
{
    Arrays.sort(a, Collections.reverseOrder());
    Arrays.sort(b);

    for (int i = 0; i < n; i++)
    if (a[i] + b[i] < k)
        return false;

    return true;
}


public static void main(String[] args) {
    Integer a[] = {1, 2, 2, 1};
    int b[] = {3, 3, 3, 4 };
    int k = 10;
    int n = a.length;

    if (twoArray(a, b, n, k))
    System.out.print("Yes");
    else
    System.out.print("No");
}
}